package com.example.eng.ui.exercisefirst;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.hilt.android.AndroidEntryPoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentExerciseFirstBinding;
import com.example.eng.ui.dictionary.DictionaryFragmentArgs;
import com.google.android.material.snackbar.Snackbar;

@AndroidEntryPoint
public class ExerciseFirstFragment extends Fragment {

    private ExerciseFirstViewModel viewModel;
    private FragmentExerciseFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExerciseFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(this);
        viewModel = provider.get(ExerciseFirstViewModel.class);

        initButtonTopics();
        initButtonTasks();
        initButtonImageAnswer();
        initEditTextAnswer();
        initButtonFirstAnswer();
        initButtonSecondAnswer();
        initButtonThirdAnswer();
        initButtonFourthAnswer();
        initGetImgId();
        initAnswerResultShowing();
        initFinishDialogShowing();
        initEmptyAnswerShowing();
        initTopicName();
        initExerciseType();
        initExerciseSecond();
        initExerciseSecondAnswers();
        initExerciseThird();
        initExerciseThirdAnswers();
        initButtonFirstAnswerThird();
        initButtonSecondAnswerThird();
        initButtonThirdAnswerThird();
        initButtonFourthAnswerThird();
    }

    private void initTopicName() {
        String topicName = DictionaryFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);
        binding.topicName.setText(topicName);
    }

    private void initExerciseType() {
        ExerciseType exerciseType = ExerciseFirstFragmentArgs.fromBundle(getArguments()).getExerciseType();
        viewModel.setExerciseType(exerciseType);
        initExerciseLayout(exerciseType);
    }

    // First exercise

    private void initEditTextAnswer() {
        binding.answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.onAnswerChanged(editable.toString());
            }
        });
    }

    private void initButtonImageAnswer() {
        binding.buttonAnswer.setOnClickListener(view -> {
            viewModel.onButtonImageAnswerClicked();
            binding.answer.setText("");
        });
    }

    private void initGetImgId() {
        viewModel.imageId.observe(getViewLifecycleOwner(), imageId -> {
            int resourceID = requireActivity().getResources().getIdentifier(imageId, "drawable", requireActivity().getPackageName());
            Drawable drawable = ContextCompat.getDrawable(requireContext(), resourceID);
            binding.imageViewExercise1.setBackground(drawable);
        });
    }

    // Second exercise

    private void initExerciseSecond() {
        viewModel.exerciseSecond.observe(getViewLifecycleOwner(), exercise -> binding.textExerciseSecond.setText(exercise));
    }

    private void initExerciseSecondAnswers() {
        viewModel.exerciseSecondAnswers.observe(getViewLifecycleOwner(), answers -> {
                    binding.firstAnswerEng.setText(answers.get(0));
                    binding.secondAnswerEng.setText(answers.get(1));
                    binding.thirdAnswerEng.setText(answers.get(2));
                    binding.fourthAnswerEng.setText(answers.get(3));
                }
        );
    }

    private void initButtonFirstAnswer() {
        binding.firstAnswerEng.setOnClickListener(view ->
                viewModel.onButtonSecondExerciseClicked(binding.firstAnswerEng.getText().toString())
        );
    }

    private void initButtonSecondAnswer() {
        binding.secondAnswerEng.setOnClickListener(view ->
                viewModel.onButtonSecondExerciseClicked(binding.secondAnswerEng.getText().toString())
        );
    }

    private void initButtonThirdAnswer() {
        binding.thirdAnswerEng.setOnClickListener(view ->
                viewModel.onButtonSecondExerciseClicked(binding.thirdAnswerEng.getText().toString())
        );
    }

    private void initButtonFourthAnswer() {
        binding.fourthAnswerEng.setOnClickListener(view ->
                viewModel.onButtonSecondExerciseClicked(binding.fourthAnswerEng.getText().toString())
        );
    }

    // Third

    private void initExerciseThird() {
        viewModel.exerciseThird.observe(getViewLifecycleOwner(), exercise -> binding.textExerciseThird.setText(exercise));
    }
    private void initExerciseThirdAnswers() {
        viewModel.exerciseThirdAnswers.observe(getViewLifecycleOwner(), answers -> {
                    binding.firstAnswerThird.setText(answers.get(0));
                    binding.secondAnswerThird.setText(answers.get(1));
                    binding.thirdAnswerThird.setText(answers.get(2));
                    binding.fourthAnswerThird.setText(answers.get(3));
                }
        );
    }
    private void initButtonFirstAnswerThird() {
        binding.firstAnswerThird.setOnClickListener(view ->
                viewModel.onButtonThirdExerciseClicked(binding.firstAnswerThird.getText().toString())
        );
    }
    private void initButtonSecondAnswerThird() {
        binding.secondAnswerThird.setOnClickListener(view ->
                viewModel.onButtonThirdExerciseClicked(binding.secondAnswerThird.getText().toString())
        );
    }
    private void initButtonThirdAnswerThird() {
        binding.thirdAnswerThird.setOnClickListener(view ->
                viewModel.onButtonThirdExerciseClicked(binding.thirdAnswerThird.getText().toString())
        );
    }
    private void initButtonFourthAnswerThird() {
        binding.fourthAnswerThird.setOnClickListener(view ->
                viewModel.onButtonThirdExerciseClicked(binding.fourthAnswerThird.getText().toString())
        );
    }

    // Navigation

    private void initButtonTopics() {
        binding.buttonTopicsEx1.setOnClickListener(view ->
                Navigation.findNavController(
                        binding.getRoot()).popBackStack(R.id.topicSelectionFragment, false
                )
        );
    }

    private void initButtonTasks() {
        binding.buttonTasksEx1.setOnClickListener(view ->
                Navigation.findNavController(binding.getRoot()).popBackStack()
        );
    }

    // Result

    private void initAnswerResultShowing() {
        viewModel.showAnswerResult.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Snackbar.make(requireView(), getString(R.string.trueAnswer), Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(requireView(), getString(R.string.falseAnswer), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void initFinishDialogShowing() {
        viewModel.showFinishDialog.observe(getViewLifecycleOwner(), result -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setPositiveButton(R.string.ok, (dialog, id) ->
                    Navigation.findNavController(binding.getRoot()).popBackStack()
            );
            builder.setMessage(getString(R.string.finish_result_dialog_pattern, result));
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    private void initEmptyAnswerShowing() {
        viewModel.showEmptyAnswerMessage.observe(getViewLifecycleOwner(), result ->
                Snackbar.make(requireView(), getString(R.string.empty_answer_message), Snackbar.LENGTH_SHORT).show()
        );
    }

    // Visibility of exercise layouts
    private void initExerciseLayout(ExerciseType exerciseType) {
        switch (exerciseType) {
            case FIRST:
                binding.firstExercise.setVisibility(View.VISIBLE);
                break;
            case SECOND:
                binding.secondExercise.setVisibility(View.VISIBLE);
                break;
            case THIRD:
                binding.thirdExercise.setVisibility(View.VISIBLE);
                break;
        }
    }
}

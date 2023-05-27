package com.example.eng.ui.exercisefirst;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentExerciseFirstBinding;
import com.google.android.material.snackbar.Snackbar;

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
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(ExerciseFirstViewModel.class);

        String topicName = ExerciseFirstFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);
        ExerciseType exerciseType = ExerciseFirstFragmentArgs.fromBundle(getArguments()).getExerciseType();

        initButtonTopics();
        initButtonImageAnswer();
        initButtonTasks();
        initNavigationToTopicSelectionFragment();
        initNavigationToSelectionTask();
        initEditTextAnswer();
        initButtonFirstAnswer();
        initButtonSecondAnswer();
        initButtonThirdAnswer();
        initButtonFourthAnswer();
        initGetImgId();
        initAnswerResultShowing();
        initExerciseLayot(exerciseType);
    }


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

    private void initButtonFirstAnswer() {
        binding.firstAnswer.setOnClickListener(view -> viewModel.onButtonFirstAnswerClicked());
    }

    private void initButtonSecondAnswer() {
        binding.secondAnswer.setOnClickListener(view -> viewModel.onButtonSecondAnswerClicked());
    }

    private void initButtonThirdAnswer() {
        binding.thirdAnswer.setOnClickListener(view -> viewModel.onButtonThirdAnswerClicked());
    }

    private void initButtonFourthAnswer() {
        binding.fourthAnswer.setOnClickListener(view -> viewModel.onButtonFourthAnswerClicked());
    }

    private void initButtonTopics() {
        binding.buttonTopicsEx1.setOnClickListener(view -> viewModel.onButtonTopicsClicked());
    }

    private void initButtonTasks() {
        binding.buttonTasksEx1.setOnClickListener(view -> viewModel.onButtonGoToSelectionTaskClicked());
    }

    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_signFragment);
            }
        });
    }

    private void initNavigationToSelectionTask() {
        viewModel.navigationToSelectionTaskFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).popBackStack(R.id.selectionTaskFragment, true);
            }
        });
    }



    private void initGetImgId() {
        viewModel.imageId.observe(getViewLifecycleOwner(), imageId -> {
            int resourceID = requireActivity().getResources().getIdentifier(imageId, "drawable", requireActivity().getPackageName());
            Drawable drawable = ContextCompat.getDrawable(requireContext(), resourceID);
            binding.imageViewExercise1.setBackground(drawable);
        });
    }

    private void initAnswerResultShowing() {
        viewModel.showAnswerResult.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Snackbar.make(requireView(), getString(R.string.trueAnswer), Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(requireView(), getString(R.string.falseAnswer), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private  void initExerciseLayot(ExerciseType exerciseType) {
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

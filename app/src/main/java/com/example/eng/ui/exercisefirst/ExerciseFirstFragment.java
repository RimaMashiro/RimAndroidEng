package com.example.eng.ui.exercisefirst;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentExerciseFirstBinding;
import com.example.eng.databinding.FragmentRegistrationBinding;
import com.example.eng.ui.registration.RegistrationViewModel;



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
        initButtonTopics();
        initButtonTasks();
        initNavigationToTopicSelectionFragment();
        initNavigationToSelectionTask();
        initEditTextAnswer();
    }

   // binding.textViewWord.setText()
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

    private  void initButtonFirstAnswer(){
        binding.firstAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonFourthAnswerClicked();
            }
        });
    };
    private void initButtonSecondAnswer(){
        binding.secondAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonSecondAnswerClicked();
            }
        });
    };
    private void initButtonThirdAnswer(){
        binding.thirdAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonThirdAnswerClicked();
            }
        });
    };
    private  void initButtonFourthAnswer(){
        binding.fourthAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonFourthAnswerClicked();
            }
        });
    };
    private void initButtonTopics() {
        binding.buttonTopicsEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonTopicsClicked();
            }
        });
    }
    private void initButtonTasks() {
        binding.buttonTasksEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonTopicsClicked();
            }
        });
    }
    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_signFragment);
            }
        });
    }
    private void initNavigationToSelectionTask() {
        viewModel.navigationToSelectionTaskFragment.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {

                    Navigation.findNavController(binding.getRoot()).popBackStack(R.id.selectionTaskFragment,true);

                }
            }
        });
    }
}

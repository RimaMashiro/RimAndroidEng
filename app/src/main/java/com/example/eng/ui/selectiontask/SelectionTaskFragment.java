package com.example.eng.ui.selectiontask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.hilt.android.AndroidEntryPoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentSelectionTaskBinding;
import com.example.eng.ui.dictionary.DictionaryFragmentArgs;
import com.example.eng.ui.exercisefirst.ExerciseType;

@AndroidEntryPoint
public class SelectionTaskFragment extends Fragment {

    private SelectionTaskViewModel viewModel;
    private FragmentSelectionTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectionTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(SelectionTaskViewModel.class);
        String topicName = SelectionTaskFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);

        initButtonGoToGrammar();
        initButtonGoToDictionary();
        initButtonGoToExerciseFirst();
        initButtonGoToExerciseSecond();
        initButtonGoToExerciseThird();
        initNavigationToGrammarFragment();
        initNavigationToDictionaryFragment();
        initNavigationToExerciseFirstFragment();
        initNavigationToTopicSelectionFragment();
        initTaskResult();
        initTopicName();
    }

    private void initTopicName() {
        String topicName = DictionaryFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);
        binding.topicName.setText(topicName);
    }
    private void initButtonGoToDictionary() {
        binding.buttonDictionary.setOnClickListener(view -> viewModel.onButtonGoToDictionaryClicked());
    }

    private void initButtonGoToGrammar() {
        binding.buttonGrammar.setOnClickListener(view -> viewModel.onButtonGoToGrammarClicked());

    }

    private void initButtonGoToExerciseFirst() {
        binding.buttonExercise1.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked(ExerciseType.FIRST));
    }

    private void initButtonGoToExerciseSecond() {
        binding.buttonExercise2.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked(ExerciseType.SECOND));
    }

    private void initButtonGoToExerciseThird() {
        binding.buttonExercise3.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked(ExerciseType.THIRD));
    }


    private void initNavigationToDictionaryFragment() {
        viewModel.navigationToDictionaryFragment.observe(getViewLifecycleOwner(), name -> {
            NavDirections action = SelectionTaskFragmentDirections.actionSelectionTaskFragmentToDictionaryFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        });
    }

    private void initNavigationToGrammarFragment() {
        viewModel.navigationToGrammarFragment.observe(getViewLifecycleOwner(), name -> {
            NavDirections action = SelectionTaskFragmentDirections.actionSelectionTaskFragmentToGrammarFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }

    private void initNavigationToExerciseFirstFragment() {
        viewModel.navigationToExerciseFirstFragment.observe(getViewLifecycleOwner(), arguments -> {
            NavDirections action = SelectionTaskFragmentDirections.actionSelectionTaskFragmentToExerciseFirstFragment(arguments.name, arguments.exerciseType);
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }

    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).popBackStack(R.id.topicSelectionFragment, true);
            }
        });
    }

    private void initTaskResult() {
        viewModel.resultFirst.observe(getViewLifecycleOwner(), result -> {
            String text = getString(R.string.result_pattern, result);
            binding.textViewCountFirst.setText(text);
        });
        viewModel.resultSecond.observe(getViewLifecycleOwner(), result -> {
            String text = getString(R.string.result_pattern, result);
            binding.textViewCountSecond.setText(text);
        });
        viewModel.resultThird.observe(getViewLifecycleOwner(), result -> {
            String text = getString(R.string.result_pattern, result);
            binding.textViewCountThird.setText(text);
        });
    }
}

package com.example.eng.ui.selectiontask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentRegistrationBinding;
import com.example.eng.databinding.FragmentSelectionTaskBinding;
import com.example.eng.ui.topicselection.TopicSelectionFragment;
import com.example.eng.ui.topicselection.TopicSelectionFragmentDirections;

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
    }
    /*private void initButtonGoToDictionary() {
        binding.buttonDictionary.setOnClickListener(view -> viewModel.onButtonGoToDictionaryClicked());
    }
     */
    private void initButtonGoToGrammar() {
        binding.buttonGrammar.setOnClickListener(view -> viewModel.onButtonGoToGrammarClicked());

    }
    private void initButtonGoToExerciseFirst() {
        binding.buttonExercise1.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked());
    }
    private void initButtonGoToExerciseSecond() {
        binding.buttonExercise2.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked());
    }
    private void initButtonGoToExerciseThird() {
        binding.buttonExercise3.setOnClickListener(view -> viewModel.onButtonGoToExerciseFirstClicked());
    }
    /*
    private void initNavigationToDictionaryFragment() {
        viewModel.navigationToGrammarFragment.observe(getViewLifecycleOwner(), name -> {
            NavDirections action= SelectionTaskFragmentDirections.actionSelectionTaskFragmentToGrammarFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        });
    }
     */
    private void initNavigationToGrammarFragment() {
        viewModel.navigationToGrammarFragment.observe(getViewLifecycleOwner(), name -> {
            NavDirections action= SelectionTaskFragmentDirections.actionSelectionTaskFragmentToGrammarFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        });
    }
    private void initNavigationToExerciseFirstFragment() {
        viewModel.navigationToExerciseFirstFragment.observe(getViewLifecycleOwner(), name -> {
            NavDirections action= SelectionTaskFragmentDirections.actionSelectionTaskFragmentToExerciseFirstFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        });
    }
    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).popBackStack(R.id.topicSelectionFragment,true);
            }
        });
    }
    //получение аргумента
    private void  initGetArg(){
        viewModel.topicName.observe(getViewLifecycleOwner(),topicName->{
            binding.topicName.setText(topicName);
        });
    }
}

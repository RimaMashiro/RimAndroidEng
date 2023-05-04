package com.example.eng.ui.selectiontask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentRegistrationBinding;

public class SelectionTaskFragment extends Fragment {

    private SelectionTaskViewModel viewModel;
    private FragmentRegistrationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(SelectionTaskViewModel.class);
    }

    private void initButtonGoToDictionary() {
        binding.buttonGoToSign.setOnClickListener(view -> viewModel.onButtonGoToDictionaryClicked());
    }

    private void initButtonGoToGrammar() {
        binding.buttonGoToSign.setOnClickListener(view -> viewModel.onButtonGoToGrammarClicked());
    }

    private void initButtonGoToExerciseFirst() {
        binding.buttonGoToSign.setOnClickListener(view -> viewModel.onButtonGoToGrammarClicked());
    }
    private void initNavigationToDictionaryFragment() {
        viewModel.navigationToDictionaryFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_signFragment);
            }
        });
    }

    private void initNavigationToExerciseFirstFragment() {
        viewModel.navigationToExerciseFirstFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_selectionTaskFragment_to_exerciseFirstFragment);
            }
        });
    }
    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).popBackStack(R.id.topicSelectionFragment,true);
            }
        });
    }
}

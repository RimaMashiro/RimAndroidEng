package com.example.eng.ui.grammar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.hilt.android.AndroidEntryPoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.R;
import com.example.eng.databinding.FragmentGrammarBinding;

@AndroidEntryPoint
public class GrammarFragment extends Fragment {

    private GrammarViewModel viewModel;
    private FragmentGrammarBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGrammarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(GrammarViewModel.class);
        String topicName = GrammarFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);

        initButtonTopics();
        initButtonTasks();
        initNavigationToTopicSelectionFragment();
        initNavigationToSelectionTask();
        initGetArg();
    }

    private void initButtonTopics() {
        binding.buttonTopics.setOnClickListener(view -> viewModel.onButtonGoToTopicsSelectionClicked());
    }

    private void initButtonTasks() {
        binding.buttonTasks.setOnClickListener(view -> viewModel.onButtonGoToSelectionTasksClicked());
    }

    private void initNavigationToTopicSelectionFragment() {
        viewModel.navigationToTopicSelectionFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_grammarFragment_to_topicSelectionFragment);
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

    //получение аргумента
    private void initGetArg() {
        viewModel.topicName.observe(getViewLifecycleOwner(), topicName -> binding.topicName.setText(topicName));
    }
}
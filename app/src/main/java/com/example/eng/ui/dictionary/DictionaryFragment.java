package com.example.eng.ui.dictionary;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eng.R;
import com.example.eng.databinding.FragmentDictionaryBinding;
import com.example.eng.databinding.FragmentTopicSelectionBinding;
import com.example.eng.ui.topicselection.TopicAdapter;
import com.example.eng.ui.topicselection.TopicSelectionViewModel;

public class DictionaryFragment extends Fragment {

    private DictionaryViewModel viewModel;
    private FragmentDictionaryBinding binding;
    private DictionaryDAO dictionaryDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(DictionaryViewModel.class);
        initRecyclerView();

    }
    private void initRecyclerView() {
        /*
        DictionaryAdapter adapter = new DictionaryAdapter( viewModel );
        binding.listDictionary.setAdapter(adapter);
        viewModel.dictionary.observe(getViewLifecycleOwner(), adapter::updateTasksList);

         */
    }

    private void initButtonTopics() {
        binding.buttonTopicsDict.setOnClickListener(view -> viewModel.onButtonGoToTopicsSelectionClicked());
    }

    private void initButtonTasks() {
        binding.buttonTasksDict.setOnClickListener(view -> viewModel.onButtonGoToSelectionTasksClicked());
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
    private void  initGetArg(){
        viewModel.topicName.observe(getViewLifecycleOwner(),topicName->{
            binding.topicName.setText(topicName);
        });
    }
}
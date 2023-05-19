package com.example.eng.ui.topicselection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.eng.databinding.FragmentTopicSelectionBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TopicSelectionFragment extends Fragment {

    private TopicSelectionViewModel viewModel;
    private FragmentTopicSelectionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopicSelectionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(TopicSelectionViewModel.class);
        initRecyclerView();
        initNavigationToSelectionTaskFragment();
    }

    private void initRecyclerView() {
        TopicAdapter adapter = new TopicAdapter(viewModel);
        binding.list.setAdapter(adapter);
        viewModel.topics.observe(getViewLifecycleOwner(), adapter::updateTasksList);
    }

    //отправление аргумента с помощтю актион
    private void initNavigationToSelectionTaskFragment() {
        viewModel.navigationToSelectionTaskFragment.observe(getViewLifecycleOwner(), name -> {
            TopicSelectionFragmentDirections.ActionTopicSelectionFragmentToSelectionTaskFragment action = TopicSelectionFragmentDirections.actionTopicSelectionFragmentToSelectionTaskFragment(name);
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }
}

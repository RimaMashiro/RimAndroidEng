package com.example.eng.ui.topicselection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.eng.databinding.FragmentTopicSelectionBinding;

import java.util.ArrayList;

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
    }
    private void initRecyclerView() {
        TopicAdapter adapter = new TopicAdapter( viewModel );
        binding.list.setAdapter(adapter);
        viewModel.topics.observe(getViewLifecycleOwner(), new Observer<ArrayList<Topic>>() {
            @Override
            public void onChanged(ArrayList<Topic> topics) {
                adapter.updateTasksList(topics);
            }
        });
    }



}

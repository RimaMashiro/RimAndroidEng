package com.example.eng.ui.grammar;

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
import com.example.eng.databinding.FragmentGrammarBinding;
import com.example.eng.databinding.FragmentPasswordResetBinding;
import com.example.eng.ui.passwordreset.PasswordResetViewModel;

public class GrammarFragment extends Fragment {

    private GrammarViewModel viewModel;
    private FragmentGrammarBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGrammarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(GrammarViewModel.class);
        initButtonTopics();
        initButtonTasks();
        initNavigationToTopicSelectionFragment();
        initNavigationToSelectionTask();

    }


    private void initButtonTopics() {

        binding.buttonTopics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonTopicsClicked();
            }
        });
    }

    private void initButtonTasks() {

        binding.buttonTasks.setOnClickListener(new View.OnClickListener() {
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



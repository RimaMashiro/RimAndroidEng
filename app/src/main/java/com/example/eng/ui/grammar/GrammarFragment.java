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
import com.example.eng.ui.dictionary.DictionaryFragmentArgs;

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
        initTopicName();
        initGrammarText();
    }

    private void initTopicName() {
        String topicName = DictionaryFragmentArgs.fromBundle(getArguments()).getName();
        viewModel.setTopicName(topicName);
        binding.topicName.setText(topicName);
    }

    private void initGrammarText() {
        viewModel.grammar.observe(getViewLifecycleOwner(), grammar -> {
            if (grammar != null) {
                binding.grammar.setText(grammar.topicGrammar);
            }
        });
    }

    private void initButtonTopics() {
        binding.buttonTopics.setOnClickListener(view ->
                Navigation.findNavController(
                        binding.getRoot()).popBackStack(R.id.topicSelectionFragment, false
                )
        );
    }

    private void initButtonTasks() {
        binding.buttonTasks.setOnClickListener(view ->
                Navigation.findNavController(binding.getRoot()).popBackStack()
        );
    }
}
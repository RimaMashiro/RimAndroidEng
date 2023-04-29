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
import com.example.eng.ui.registration.RegistrationViewModel;

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

    private void initButtonGoToSign() {
        binding.buttonGoToSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonGoToSignClicked();
            }
        });
    }

    private void initNavigationToSignFragment() {
        viewModel.navigationToSignFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_signFragment);
            }
        });
    }






}

package com.example.eng.ui.registration;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.android.material.snackbar.Snackbar;

public class RegistrationFragment extends Fragment {

    private RegistrationViewModel viewModel;
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
        viewModel = provider.get(RegistrationViewModel.class);
        initEditTextEmail();
        initEditTextPassword();
        initButtonRegister();
        initButtonGoToSign();
        initNavigationToSignFragment();
        initErrorShowing();
    }

    private void initEditTextEmail() {
        binding.editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.onEmailChanged(editable.toString());
            }
        });


    }

    private void initEditTextPassword() {
        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.onPasswordChanged(editable.toString());
            }
        });
    }

    private void initButtonRegister() {
        binding.buttonRegister.setOnClickListener(view -> viewModel.onButtonRegisterClicked());
    }

    private void initButtonGoToSign() {
        binding.buttonGoToSign.setOnClickListener(view -> viewModel.onButtonGoToSignClicked());
    }

    private void initNavigationToSignFragment() {
        viewModel.navigationToSignFragment.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registrationFragment_to_signFragment);
            }
        });
    }



    private void initErrorShowing() {
        viewModel.showErrorMessage.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Snackbar.make(requireView(), getString(R.string.registrationerror), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}

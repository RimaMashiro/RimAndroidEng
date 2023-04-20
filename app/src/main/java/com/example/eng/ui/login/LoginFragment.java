package com.example.eng.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eng.R;
import com.example.eng.databinding.FragmentLoginBinding;
import com.google.android.material.snackbar.Snackbar;


public class LoginFragment extends Fragment {


    private LoginViewModel viewModel;

    private FragmentLoginBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider= new ViewModelProvider(requireActivity());
        viewModel= provider.get(LoginViewModel.class);
        initEditTextSignEmail();
        initEditTextSignPassword();
        initButtonSign();
        initButtonPasswordReset();
        initErrorShowing();
    }

    private void initEditTextSignEmail(){

        binding.editTextSignEmail.addTextChangedListener(new TextWatcher() {
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
    private void initEditTextSignPassword(){

        binding.editTextSignPassword.addTextChangedListener(new TextWatcher(){
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

    private void initButtonSign(){

        binding.buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonSignClicked();
            }
        });
    }

    private void initButtonPasswordReset() {
        binding.buttonPasswordReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonPasswordResetClicked();
            }
        });
    }

    private void initNavigationToPasswordResetFragment() {
        viewModel.navigationToPasswordResetFragment.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_signFragment_to_passwordResetFragment);

                }
            }
        });
    }
    private void initErrorShowing() {
        viewModel.showErrorMessage.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Snackbar.make(requireView(), getString(R.string.loginerror), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}


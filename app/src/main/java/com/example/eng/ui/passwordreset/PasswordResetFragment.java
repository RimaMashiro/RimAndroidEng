package com.example.eng.ui.passwordreset;

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
import android.widget.Button;
import android.widget.EditText;

import com.example.eng.databinding.FragmentPasswordResetBinding;
import com.google.android.material.snackbar.Snackbar;
import com.example.eng.R;


public class PasswordResetFragment extends Fragment {

    private PasswordResetViewModel viewModel;
    private FragmentPasswordResetBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPasswordResetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(requireActivity());
        viewModel = provider.get(PasswordResetViewModel.class);
        initEditTextResetEmail();
        initButtonResetPassword();}

    private void initEditTextResetEmail() {

        binding.editTextResetEmail.addTextChangedListener(new TextWatcher() {
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


    private void initButtonResetPassword() {

        binding.buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonResetPasswordClicked();
            }
        });
    }

    private void initNavigationNewPasswordFragment() {
        viewModel.navigationToNewPasswordFragment.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_passwordResetFragment_to_newPasswordFragment);

                }
            }
        });
    }


}
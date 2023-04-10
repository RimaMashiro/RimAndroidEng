package com.example.eng.ui.newpassword;

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

import com.example.eng.R;
import com.example.eng.databinding.FragmentNewPasswordBinding;
import com.example.eng.ui.login.LoginFragment;


public class NewPasswordFragment extends Fragment {

    private  NewPasswordViewModel viewModel;
    private FragmentNewPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider provider= new ViewModelProvider(requireActivity());
        viewModel= provider.get(NewPasswordViewModel.class);
        initEditTextNewPassword();
        initButtonNewPassword();

    }

    private void initEditTextNewPassword(){

        binding.editTextNewPassword.addTextChangedListener(new TextWatcher(){
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


    private void initButtonNewPassword(){

        binding.buttonNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onButtonNewPasswordClicked();
            }
        });
    }
    private void initNavigationToSignFragment() {
        viewModel.navigationToSignFragment.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {

                    Navigation.findNavController(binding.getRoot()).popBackStack(R.id.loginFragment,true);

                }
            }
        });
    }

}
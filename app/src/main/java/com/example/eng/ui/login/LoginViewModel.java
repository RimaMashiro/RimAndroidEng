package com.example.eng.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.AuthManager;
import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends ViewModel {

    private AuthManager authManager = AuthManager.getInstance();
    private String email;
    private String password;

    private SingleLiveEvent<Boolean> _navigationToPasswordResetFragment = new SingleLiveEvent<Boolean>();

    LiveData<Boolean> navigationToPasswordResetFragment = _navigationToPasswordResetFragment;

    LiveData<FirebaseUser> user = authManager.user;
    LiveData<Boolean> showErrorMessage = authManager.showErrorMessage;


    public void onEmailChanged(String email) {
        this.email = email;
    }

    public void onPasswordChanged(String password) {
        this.password = password;
    }

    public void onButtonSignClicked() {
        authManager.login(email, password);

    }

    public void onButtonPasswordResetClicked() {
        _navigationToPasswordResetFragment.setValue(true);
    }
}
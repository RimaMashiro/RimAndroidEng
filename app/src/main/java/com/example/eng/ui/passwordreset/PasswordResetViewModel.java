package com.example.eng.ui.passwordreset;

import androidx.lifecycle.ViewModel;

import com.example.eng.data.AuthManager;

public class PasswordResetViewModel extends ViewModel {

    private final AuthManager authManager = AuthManager.getInstance();
    private String email;

    public void onEmailChanged(String email) {
        this.email = email;
    }

    public void onButtonResetPasswordClicked() {
        authManager.sendPasswordReset(email);
    }
}

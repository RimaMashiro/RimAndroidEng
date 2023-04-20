package com.example.eng.ui.passwordreset;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.AuthManager;
import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseUser;

public class PasswordResetViewModel extends ViewModel {

    private AuthManager authManager = AuthManager.getInstance();
    private String email;

    public void onEmailChanged(String email){
        this.email=email;
    }


    public void onButtonResetPasswordClicked(){

        authManager.sendPasswordReset(email);
    }

}

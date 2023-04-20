package com.example.eng.ui.newpassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.AuthManager;
import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseUser;

public class NewPasswordViewModel extends ViewModel {

    private AuthManager authManager = AuthManager.getInstance();
    private String password;


    LiveData<Boolean> navigationToSignFragment = authManager.navigationToSignFragment;

    LiveData<FirebaseUser> user = authManager.user;

    public void onPasswordChanged(String password) {
        this.password = password;
    }

    public void onButtonNewPasswordClicked() {
        authManager.updatePassword(password);

    }

}

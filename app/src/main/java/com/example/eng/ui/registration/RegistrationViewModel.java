package com.example.eng.ui.registration;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.eng.AuthManager;
import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationViewModel extends ViewModel {
    private AuthManager authManager = AuthManager.getInstance();

    private String email;
    private String password;

    private SingleLiveEvent<Boolean> _navigationToSignFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSignFragment = _navigationToSignFragment;

    LiveData<FirebaseUser> user = authManager.user;

    LiveData<Boolean> showErrorMessage = authManager.showErrorMessage;

    public void onEmailChanged(String email) {
        this.email = email;
    }

    public void onPasswordChanged(String password) {
        this.password = password;
    }

    public void onButtonRegisterClicked() {
        authManager.register(email, password);
    }

    public void onButtonGoToSignClicked() {
        _navigationToSignFragment.setValue(true);
    }
}
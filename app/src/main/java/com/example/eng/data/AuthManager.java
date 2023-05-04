package com.example.eng.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {

    private final FirebaseAuth firebase = FirebaseAuth.getInstance();

    private final MutableLiveData<FirebaseUser> _user = new MutableLiveData<>(firebase.getCurrentUser());
    public LiveData<FirebaseUser> user = _user;

    private final SingleLiveEvent<Boolean> _showErrorMessage = new SingleLiveEvent<>();
    public LiveData<Boolean> showErrorMessage = _showErrorMessage;

    private SingleLiveEvent<Boolean> _navigationToSignFragment = new SingleLiveEvent<Boolean>();
    public LiveData<Boolean> navigationToSignFragment = _navigationToSignFragment;

    private final SingleLiveEvent<Boolean> _infoMessage = new SingleLiveEvent<>();
    public LiveData<Boolean> infoMessage = _infoMessage;
    private static AuthManager instance;

    private AuthManager() {
    }

    public static AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }

    public void register(String email, String password) {
        firebase.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        _user.setValue(firebase.getCurrentUser());
                    } else {
                        _showErrorMessage.setValue(true);
                    }
                });
    }

    public void login(String email, String password) {
        firebase.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        _user.setValue(firebase.getCurrentUser());
                    } else {
                        _showErrorMessage.setValue(true);
                    }
                });
    }

    public void sendPasswordReset(String email) {
        firebase.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        _infoMessage.setValue(true);
                    }
                });
    }

    public void updatePassword(String password) {
        user.getValue().updatePassword(password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        _navigationToSignFragment.setValue(true);
                    }
                });
    }
}
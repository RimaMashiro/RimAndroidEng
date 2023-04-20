package com.example.eng;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.eng.util.SingleLiveEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {
    private static AuthManager instance;

    private AuthManager(){} // #2

    public static AuthManager getInstance(){ // #3
        if(instance == null){		//если объект еще не создан
            instance = new AuthManager();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }
    private final FirebaseAuth firebase = FirebaseAuth.getInstance();

    private final MutableLiveData<FirebaseUser> _user = new MutableLiveData<>();
    public LiveData<FirebaseUser> user = _user;

    private final SingleLiveEvent<Boolean> _showErrorMessage = new SingleLiveEvent<>();
    public LiveData<Boolean> showErrorMessage = _showErrorMessage;
    private SingleLiveEvent<Boolean> _navigationToSignFragment = new SingleLiveEvent<Boolean>();
    public LiveData<Boolean> navigationToSignFragment = _navigationToSignFragment;
    private final SingleLiveEvent<Boolean> _infoMessage = new SingleLiveEvent<>();
    public LiveData<Boolean>  infoMessage= _infoMessage;

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

    private final MutableLiveData<FirebaseUser> _user = new MutableLiveData<>();
    public LiveData<FirebaseUser> user = _user;

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

    public void sendPasswordReset(String email){
        firebase.sendPasswordResetEmail(email)
                .addOnCompleteListener(task ->  {
                        if (task.isSuccessful()) {
                            _infoMessage.setValue(true);
                        }
                });
    }

    public void updatePassword(String password) {

        user.getValue().updatePassword(password)
                .addOnCompleteListener(task ->{
                        if (task.isSuccessful()) {
                            _navigationToSignFragment.setValue(true);;
                    }
                });

    }

    private void reload() {
    }

    private void updateUI(FirebaseUser user) {
    }

}

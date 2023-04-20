package com.example.eng;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;
import com.google.firebase.auth.FirebaseUser;

public class MainViewModel extends ViewModel {
    private AuthManager authManager = AuthManager.getInstance();

    LiveData<FirebaseUser> user = authManager.user;

}

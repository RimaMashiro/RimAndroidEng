
package com.example.eng.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;
import com.example.eng.data.AuthManager;
import com.google.firebase.auth.FirebaseUser;

public class MainViewModel extends ViewModel {

    private final AuthManager authManager = AuthManager.getInstance();

    LiveData<FirebaseUser> user = authManager.user;
}

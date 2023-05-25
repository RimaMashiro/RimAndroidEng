
package com.example.eng.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.AuthManager;
import com.example.eng.data.DataManager;
import com.example.eng.data.SharedPreferencesManager;
import com.google.firebase.auth.FirebaseUser;

import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@HiltViewModel
public class MainViewModel extends ViewModel {

    LiveData<FirebaseUser> user = AuthManager.getInstance().user;

    @Inject
    public MainViewModel(DataManager dataManager, SharedPreferencesManager sharedPreferencesManager) {
        if(sharedPreferencesManager.checkIsFirstLaunch()){
            dataManager.addData();
            sharedPreferencesManager.setIsFirstLaunch();
        }
    }
}

package com.example.eng.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.ViewModel;

import android.util.Patterns;
/*
import com.example.myapplication1.data.LoginRepository;
import com.example.myapplication1.data.Result;
import com.example.myapplication1.data.model.LoggedInUser;

 */
import com.example.eng.R;

public class LoginViewModel extends ViewModel {

    private String email;
    private  String password;

    private SingleLiveEvent<Boolean> _navigationToPasswordResetFragment= new SingleLiveEvent<Boolean>(false) ;

    LiveData<Boolean> navigationToPasswordResetFragment= _navigationToPasswordResetFragment;
    public void onEmailChanged(String email){
        this.email=email;
    }

    public void onPasswordChanged(String password){
        this.password=password;
    }

    public void onButtonSignClicked(){

    }

    public void onButtonPasswordResetClicked(){
        _navigationToPasswordResetFragment.setValue(true);
    }
}
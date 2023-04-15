package com.example.eng.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

public class RegistrationViewModel extends ViewModel {
    private String email;
    private  String password;

    private SingleLiveEvent<Boolean> _navigationToSignFragment= new SingleLiveEvent<>() ;
    LiveData<Boolean> navigationToSignFragment= _navigationToSignFragment ;
    public void onEmailChanged(String email){
        this.email=email;
    }

    public void onPasswordChanged(String password){
        this.password=password;
    }

    public void onButtonRegisterClicked(){

    }

    public void onButtonGoToSignClicked(){
        _navigationToSignFragment.setValue(true);
    }

}
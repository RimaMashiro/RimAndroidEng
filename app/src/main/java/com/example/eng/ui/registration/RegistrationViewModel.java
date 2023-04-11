package com.example.eng.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrationViewModel extends ViewModel {
    private String email;
    private  String password;

    private MutableLiveData<Boolean> _navigationToSignFragment= new MutableLiveData<Boolean>(false) ;
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
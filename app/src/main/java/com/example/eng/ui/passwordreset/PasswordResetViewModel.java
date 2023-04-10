package com.example.eng.ui.passwordreset;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PasswordResetViewModel extends ViewModel {
    private String email;

    private MutableLiveData<Boolean> _navigationToNewPasswordFragment= new MutableLiveData<Boolean>(false) ;
    LiveData<Boolean> navigationToNewPasswordFragment= _navigationToNewPasswordFragment ;

    public void onEmailChanged(String email){
        this.email=email;
    }


    public void onButtonResetPasswordClicked(){
        _navigationToNewPasswordFragment.setValue(true);
    }

}

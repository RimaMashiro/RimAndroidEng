package com.example.eng.ui.passwordreset;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

public class PasswordResetViewModel extends ViewModel {
    private String email;

    private SingleLiveEvent<Boolean> _navigationToNewPasswordFragment= new SingleLiveEvent<Boolean>(false) ;
    LiveData<Boolean> navigationToNewPasswordFragment= _navigationToNewPasswordFragment ;

    public void onEmailChanged(String email){
        this.email=email;
    }


    public void onButtonResetPasswordClicked(){
        _navigationToNewPasswordFragment.setValue(true);
    }

}

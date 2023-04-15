package com.example.eng.ui.newpassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewPasswordViewModel extends ViewModel {

    private  String password;

    private SingleLiveEvent<Boolean> _navigationToSignFragment= new SingleLiveEvent<Boolean>(false) ;
    LiveData<Boolean> navigationToSignFragment= _navigationToSignFragment ;
    public void onPasswordChanged(String password){
        this.password=password;
    }

    public void onButtonNewPasswordClicked(){_navigationToSignFragment.setValue(true);}

}

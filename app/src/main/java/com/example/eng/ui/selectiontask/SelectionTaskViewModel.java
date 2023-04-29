package com.example.eng.ui.selectiontask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

public class SelectionTaskViewModel extends ViewModel {
    private MutableLiveData<Boolean> _navigationToSignFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSignFragment = _navigationToSignFragment;

    public void onButtonGoToSignClicked() {
        _navigationToSignFragment.setValue(true);
    }

    public void onButtonGoToSignClicked() {
        _navigationToSignFragment.setValue(true);
    }

    public void onButtonGoToSignClicked() {
        _navigationToSignFragment.setValue(true);
    }

    public void onButtonGoToSignClicked() {
        _navigationToSignFragment.setValue(true);
    }

}

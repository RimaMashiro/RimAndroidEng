package com.example.eng.ui.grammar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.eng.util.SingleLiveEvent;

public class GrammarViewModel extends ViewModel{

    private SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;
    private SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    public void onButtonTopicsClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}

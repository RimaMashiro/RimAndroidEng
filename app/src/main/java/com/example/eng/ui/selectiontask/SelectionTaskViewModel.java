package com.example.eng.ui.selectiontask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

public class SelectionTaskViewModel extends ViewModel {
    private MutableLiveData<Boolean> _navigationToDictionaryFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToDictionaryFragment = _navigationToDictionaryFragment;

    private MutableLiveData<Boolean> _navigationToGrammarFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToGrammarFragment = _navigationToGrammarFragment;

    private MutableLiveData<Boolean> _navigationToExerciseFirstFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToExerciseFirstFragment = _navigationToExerciseFirstFragment;

    private MutableLiveData<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    public void onButtonGoToDictionaryClicked() {
        _navigationToDictionaryFragment.setValue(true);
    }

    public void onButtonGoToGrammarClicked() {
        _navigationToGrammarFragment.setValue(true);
    }

    public void onButtonGoToExerciseFirstClicked() {
        _navigationToExerciseFirstFragment.setValue(true);
    }

    public void onButtonGoToTopicClicked() {
       // _navigationToTopicFragment.setValue(true);
    }
}

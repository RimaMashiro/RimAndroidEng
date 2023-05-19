package com.example.eng.ui.selectiontask;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SelectionTaskViewModel extends ViewModel {
    private SelectionTaskDAO selectionTaskDAO;

    private final SingleLiveEvent<Boolean> _navigationToDictionaryFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToDictionaryFragment = _navigationToDictionaryFragment;

    private final SingleLiveEvent<String> _navigationToGrammarFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToGrammarFragment = _navigationToGrammarFragment;

    private final SingleLiveEvent<String> _navigationToExerciseFirstFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToExerciseFirstFragment = _navigationToExerciseFirstFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    //для пердачи аргумента имени темы
    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    LiveData<SelectionTask> selectionTask;

    @Inject
    public SelectionTaskViewModel(SelectionTaskDAO selectionTaskDAO) {
        this.selectionTaskDAO = selectionTaskDAO;
    }

    //public void onButtonGoToDictionaryClicked() {
    //_navigationToDictionaryFragment.setValue(true);
    //}

    public void onButtonGoToGrammarClicked() {
        _navigationToGrammarFragment.setValue(topicName.getValue());
    }

    public void onButtonGoToExerciseFirstClicked() {
        _navigationToExerciseFirstFragment.setValue(topicName.getValue());
    }

    public void onButtonGoToTopicClicked() {
        // _navigationToTopicFragment.setValue(true);
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
        selectionTask = this.selectionTaskDAO.getAll(topicName);
    }
}

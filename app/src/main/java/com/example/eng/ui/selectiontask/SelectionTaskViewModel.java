package com.example.eng.ui.selectiontask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.eng.ui.grammar.Grammar;
import com.example.eng.util.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel

public class SelectionTaskViewModel extends ViewModel {
    private SelectionTaskDAO selectionTaskDAO;
    private MutableLiveData<Boolean> _navigationToDictionaryFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToDictionaryFragment = _navigationToDictionaryFragment;

    private MutableLiveData<String> _navigationToGrammarFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToGrammarFragment = _navigationToGrammarFragment;

    private MutableLiveData<String> _navigationToExerciseFirstFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToExerciseFirstFragment = _navigationToExerciseFirstFragment;

    private MutableLiveData<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    //для пердачи аргумента имени темы
    private MutableLiveData<String>_topicName=new MutableLiveData<>();
    LiveData<String> topicName=_topicName;
    LiveData<SelectionTask> selectionTask;

    @Inject
    public SelectionTaskViewModel(SavedStateHandle savedStateHandle){
        String topicName=savedStateHandle.get("name");
        _topicName.setValue(topicName);
        this.selectionTaskDAO = selectionTaskDAO;
        selectionTask= this.selectionTaskDAO.getAll(topicName);
     }

    public void onButtonGoToDictionaryClicked() {
        _navigationToDictionaryFragment.setValue(true);
    }

    public void onButtonGoToGrammarClicked() {
        _navigationToGrammarFragment.setValue(topicName.getValue());
    }
    public void onButtonGoToExerciseFirstClicked() {
        _navigationToExerciseFirstFragment.setValue(topicName.getValue());
    }

     public void onButtonGoToTopicClicked() {
       // _navigationToTopicFragment.setValue(true);
    }
}

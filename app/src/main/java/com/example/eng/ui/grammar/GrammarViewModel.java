package com.example.eng.ui.grammar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

import javax.inject.Inject;

public class GrammarViewModel extends ViewModel {
    private  GrammarDAO grammarDAO;

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;
    private MutableLiveData<String> _topicName=new MutableLiveData<>();
    LiveData<String> topicName=_topicName;
    LiveData<Grammar> grammar;
    @Inject
    public GrammarViewModel(GrammarDAO grammarDAO, SavedStateHandle savedStateHandle){
        String topicName=savedStateHandle.get("name");
        _topicName.setValue(topicName);
        this.grammarDAO = grammarDAO;
        grammar= this.grammarDAO.getAll(topicName);
    }
    public void onButtonGoToTopicsSelectionClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}

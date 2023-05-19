package com.example.eng.ui.grammar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.SharedPreferencesManager;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.util.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

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
    public GrammarViewModel(GrammarDAO grammarDAO, SavedStateHandle savedStateHandle, SharedPreferencesManager sharedPreferencesManager){
        String topicName=savedStateHandle.get("name");
        _topicName.setValue(topicName);
        this.grammarDAO = grammarDAO;
        grammar= this.grammarDAO.getAll(topicName);
        if (sharedPreferencesManager.checkIsFirstLaunch()) {//если первый запуск
            this.grammarDAO.insertAll(getGrammarList());//добавляем все
            sharedPreferencesManager.setIsFirstLaunch();//не первый запуск
        }
    }
    public void onButtonGoToTopicsSelectionClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }

    public ArrayList<Grammar> getGrammarList() {
        ArrayList<Grammar> grammar = new ArrayList<>();
        grammar.add(new Grammar("Grammar1","Topic1"));
        grammar.add(new Grammar("Grammar2","Topic2"));
        grammar.add(new Grammar("Grammar3","Topic3"));
        grammar.add(new Grammar("Grammar4","Topic4"));
        grammar.add(new Grammar("Grammar5","Topic5"));
        return grammar;
    }
}

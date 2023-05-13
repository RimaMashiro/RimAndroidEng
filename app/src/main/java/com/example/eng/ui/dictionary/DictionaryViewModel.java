package com.example.eng.ui.dictionary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.SharedPreferencesManager;
import com.example.eng.ui.topicselection.TopicDAO;
import com.example.eng.util.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DictionaryViewModel extends ViewModel {
    private DictionaryDAO dictionaryDAO;
    //public final LiveData<List<Dictionary>> dictionary;

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;
    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;
    private MutableLiveData<String> _topicName=new MutableLiveData<>();
    LiveData<String> topicName=_topicName;

    @Inject
    public DictionaryViewModel(TopicDAO topicDAO, SharedPreferencesManager sharedPreferencesManager) {
        this.dictionaryDAO = dictionaryDAO;
        //dictionary = this.dictionaryDAO.getAll();

        if (sharedPreferencesManager.checkIsFirstLaunch()) {//если первый запуск
            //this.dictionaryDAO.insertAll(getDictionaryList());//добавляем все
            sharedPreferencesManager.setIsFirstLaunch();//не первый запуск
        }
    }

    public void onButtonGoToTopicsSelectionClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }

    public ArrayList<Dictionary> getDictionaryList() {
        ArrayList<Dictionary> dictionary = new ArrayList<>();
        dictionary.add(new Dictionary("Topic1"));
        dictionary.add(new Dictionary("Topic2"));
        dictionary.add(new Dictionary("Topic3"));
        dictionary.add(new Dictionary("Topic4"));
        dictionary.add(new Dictionary("Topic5"));
        return dictionary;}
}
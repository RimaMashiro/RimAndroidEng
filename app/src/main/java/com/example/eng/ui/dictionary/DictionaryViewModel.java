package com.example.eng.ui.dictionary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.SharedPreferencesManager;
import com.example.eng.ui.topicselection.TopicDAO;
import com.example.eng.util.SingleLiveEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DictionaryViewModel extends ViewModel {
    private DictionaryDAO dictionaryDAO;
    //public final LiveData<List<Dictionary>> dictionary

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;
    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;
    private MutableLiveData<String> _topicName=new MutableLiveData<>();
    LiveData<String> topicName=_topicName;
    LiveData<Dictionary> dictionary;

    @Inject
    public DictionaryViewModel(DictionaryDAO dictionaryDAO, SharedPreferencesManager sharedPreferencesManager) {
        this.dictionaryDAO = dictionaryDAO;
        if (sharedPreferencesManager.checkIsFirstLaunch()) {//если первый запуск
            this.dictionaryDAO.insertAll(getDictionaryList());//добавляем все
            sharedPreferencesManager.setIsFirstLaunch();//не первый запуск
        }
    }
    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
        dictionary = this.dictionaryDAO.getAll(topicName);
    }

    public void onButtonGoToTopicsSelectionClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }

    public ArrayList<Dictionary> getDictionaryList() {
        ArrayList<Dictionary> dictionary = new ArrayList<>();
        String [] wordEn= new String[]{"word","write"};
        String [] wordRu= new String[]{"слово","писать"};
        List<String> wordEng = Arrays.asList(wordEn);
        List<String> wordRus = Arrays.asList(wordRu);

        dictionary.add(new Dictionary(wordEng, wordRus,"Topic1"));
        dictionary.add(new Dictionary(wordEng, wordRus,"Topic2"));
        dictionary.add(new Dictionary(wordEng, wordRus,"Topic3"));
        dictionary.add(new Dictionary(wordEng, wordRus,"Topic4"));
        dictionary.add(new Dictionary(wordEng, wordRus,"Topic5"));
        return dictionary;}
}
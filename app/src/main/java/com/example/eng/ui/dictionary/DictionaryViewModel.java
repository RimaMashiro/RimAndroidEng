package com.example.eng.ui.dictionary;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.SharedPreferencesManager;
import com.example.eng.util.SingleLiveEvent;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DictionaryViewModel extends ViewModel {

    private DictionaryDAO dictionaryDAO;

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    LiveData<Dictionary> dictionary = Transformations.map(topicName, new Function<String, Dictionary>() {

        @Override
        public Dictionary apply(String input) {
            if (topicName.getValue() != null) {
                return dictionaryDAO.getAll();
            }
            return null;
        }
    });

    @Inject
    public DictionaryViewModel(DictionaryDAO dictionaryDAO, SharedPreferencesManager sharedPreferencesManager) {
        this.dictionaryDAO = dictionaryDAO;
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
    }

    public void onButtonGoToTopicsSelectionClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}
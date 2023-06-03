package com.example.eng.ui.dictionary;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DictionaryViewModel extends ViewModel {

    private DictionaryDAO dictionaryDAO;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    LiveData<Dictionary> dictionary = Transformations.map(topicName, new Function<String, Dictionary>() {

        @Override
        public Dictionary apply(String input) {
            if (input != null) {
                return dictionaryDAO.getAll(input);
            }
            return null;
        }
    });

    @Inject
    public DictionaryViewModel(DictionaryDAO dictionaryDAO) {
        this.dictionaryDAO = dictionaryDAO;
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
    }
}
package com.example.eng.ui.grammar;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@HiltViewModel
public class GrammarViewModel extends ViewModel {
    @Inject
    public GrammarDAO grammarDAO;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    LiveData<Grammar> grammar = Transformations.map(topicName, new Function<String, Grammar>() {

        @Override
        public Grammar apply(String input) {
            if (topicName.getValue() != null) {
                return grammarDAO.getAll(topicName.getValue());
            }
            return null;
        }
    });

    @Inject
    public GrammarViewModel(GrammarDAO grammarDAO) {
        this.grammarDAO = grammarDAO;
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
    }
}

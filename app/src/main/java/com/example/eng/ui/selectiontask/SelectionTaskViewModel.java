package com.example.eng.ui.selectiontask;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.ResultRepository;
import com.example.eng.ui.exercisefirst.ExerciseType;
import com.example.eng.util.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SelectionTaskViewModel extends ViewModel {
    private ResultRepository resultRepository;

    private final SingleLiveEvent<String> _navigationToDictionaryFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToDictionaryFragment = _navigationToDictionaryFragment;

    private final SingleLiveEvent<String> _navigationToGrammarFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToGrammarFragment = _navigationToGrammarFragment;

    private final SingleLiveEvent<Arguments> _navigationToExerciseFirstFragment = new SingleLiveEvent<>();
    LiveData<Arguments> navigationToExerciseFirstFragment = _navigationToExerciseFirstFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    //для пердачи аргумента имени темы
    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    private final MutableLiveData<String> _resultFirst = new MutableLiveData<>();
    LiveData<String> resultFirst = _resultFirst;

    private final MutableLiveData<String> _resultSecond = new MutableLiveData<>();
    LiveData<String> resultSecond = _resultSecond;

    private final MutableLiveData<String> _resultThird = new MutableLiveData<>();
    LiveData<String> resultThird = _resultThird;

    @Inject
    public SelectionTaskViewModel(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
        _resultFirst.setValue("" + resultRepository.getCountFirst());
        _resultSecond.setValue("" + resultRepository.getCountSecond());
        _resultThird.setValue("" + resultRepository.getCountThird());
    }

    public void onButtonGoToDictionaryClicked() {
        _navigationToDictionaryFragment.setValue(topicName.getValue());
    }

    public void onButtonGoToGrammarClicked() {
        _navigationToGrammarFragment.setValue(topicName.getValue());
    }

    public void onButtonGoToExerciseFirstClicked(ExerciseType exerciseType) {
        Arguments arguments = new Arguments(topicName.getValue(), exerciseType);
        _navigationToExerciseFirstFragment.setValue(arguments);
    }

    public void onButtonGoToTopicClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
    }
}

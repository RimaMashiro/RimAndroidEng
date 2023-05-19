package com.example.eng.ui.exercisefirst;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

import dagger.hilt.android.lifecycle.HiltViewModel;
import java.util.List;
import javax.inject.Inject;

@HiltViewModel
public class ExerciseFirstViewModel extends ViewModel {
    private String answer;
    private ExerciseFirstDAO exerciseDAO;

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    private final MutableLiveData<Integer> _imageId = new MutableLiveData<>();
    LiveData<Integer> imageId = _imageId;

    @Inject
    public ExerciseFirstViewModel(ExerciseFirstDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonFirstAnswerClicked() {
    }

    public void onButtonSecondAnswerClicked() {
    }

    public void onButtonThirdAnswerClicked() {
    }

    public void onButtonFourthAnswerClicked() {
    }

    public void setText() {
    }

    public void onButtonTopicsClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToSelectionTaskClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);
        List<Exercise> exercises = exerciseDAO.getAll(topicName);
        if (!exercises.isEmpty()) {
            Exercise exercise = exercises.get(0);
            _imageId.setValue(exercise.getImageId());
        }
    }
}



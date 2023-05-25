package com.example.eng.ui.exercisefirst;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.ResultRepository;
import com.example.eng.util.SingleLiveEvent;

import dagger.hilt.android.lifecycle.HiltViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

@HiltViewModel
public class ExerciseFirstViewModel extends ViewModel {
    private String answer;
    private ExerciseFirstDAO exerciseDAO;
    private ExerciseRepository exerciseRepository;
    private ResultRepository resultRepository;
    private Exercise exercise;
    private List<Exercise> exercises;

    private final SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;

    private final SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    private final MutableLiveData<Integer> _imageId = new MutableLiveData<>();
    LiveData<Integer> imageId = _imageId;

    private final SingleLiveEvent<Boolean> _showTrueAnswer = new SingleLiveEvent<>();
    public LiveData<Boolean> showTrueAnswer = _showTrueAnswer;

    private final SingleLiveEvent<Boolean> _showFalseAnswer = new SingleLiveEvent<>();
    public LiveData<Boolean> showFalseAnswer = _showFalseAnswer;

    @Inject
    public ExerciseFirstViewModel(ExerciseFirstDAO exerciseDAO, ExerciseRepository exerciseRepository, ResultRepository resultRepository) {
        this.exerciseDAO = exerciseDAO;
        this.exerciseRepository = exerciseRepository;
        this.resultRepository = resultRepository;
    }

    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonFirstAnswerClicked() {
        answerFirstExercise(answer);
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
        exercises = exerciseDAO.getAll(topicName);
        Log.d("TAG", exercises.toString());
        if (!exercises.isEmpty()) {
            exercise = exercises.get(0);
            _imageId.setValue(exercise.getImageId());
        }
    }

    public void answerFirstExercise(String answer) {
        HashMap<String, Integer> editAnswer = exerciseRepository.getImageAnswers();
        for (Map.Entry<String, Integer> str : editAnswer.entrySet()) {
            if (answer.equals(str.getKey())) {
                _showTrueAnswer.setValue(true);
                resultRepository.setCountFirst();
            } else {
                _showFalseAnswer.setValue(true);
            }
        }
        int index = exercises.indexOf(exercise);
        if (index < exercises.size() - 1) {
            exercise = exercises.get(index + 1);
            _imageId.setValue(exercise.getImageId());
        }
    }


    public void answerSecondExercise() {


    }

    public void answerThirdExercise() {

    }
}




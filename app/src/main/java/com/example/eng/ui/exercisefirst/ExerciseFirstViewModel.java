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
    private String answer = "";
    private ExerciseFirstDAO exerciseDAO;
    private ExerciseRepository exerciseRepository;
    private ResultRepository resultRepository;
    private Exercise exercise;
    private List<Exercise> exercises;
    private ExerciseType type;
    private List<String> listExerciseSecond;
    private List<String> listAnswersSecond;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    private final MutableLiveData<String> _imageId = new MutableLiveData<>();
    LiveData<String> imageId = _imageId;

    private final MutableLiveData<String> _wordsExerciseSecond = new MutableLiveData<>();
    LiveData<String> wordsExerciseSecond = _wordsExerciseSecond;
    private final MutableLiveData<List<String>> _wordsAnswersSecond = new MutableLiveData<>();
    LiveData<List<String>> wordsAnswersSecond =_wordsAnswersSecond ;


    private final SingleLiveEvent<Boolean> _showAnswerResult = new SingleLiveEvent<>();
    public LiveData<Boolean> showAnswerResult = _showAnswerResult;

    private final SingleLiveEvent<Integer> _showFinishDialog = new SingleLiveEvent<>();
    public LiveData<Integer> showFinishDialog = _showFinishDialog;

    private final SingleLiveEvent<Boolean> _showEmptyAnswerMessage = new SingleLiveEvent<>();
    public LiveData<Boolean> showEmptyAnswerMessage = _showEmptyAnswerMessage;

    @Inject
    public ExerciseFirstViewModel(ExerciseFirstDAO exerciseDAO, ExerciseRepository exerciseRepository, ResultRepository resultRepository) {
        this.exerciseDAO = exerciseDAO;
        this.exerciseRepository = exerciseRepository;
        this.resultRepository = resultRepository;
    }

    public void setExerciseType(ExerciseType type) {
        this.type = type;
        Log.d("TAG", type.toString());
        resultRepository.clearResult(type);
        exercises = exerciseDAO.getAll(topicName.getValue(), type);
        Log.d("TAG", exercises.toString());
        if (!exercises.isEmpty()) {
            exercise = exercises.get(0);
            switch (type){
                case FIRST:
                    startExerciseFirst();
                    break;
                case SECOND:
                    startExerciseSecond();
                    break;
                case THIRD:
                    startExerciseThird();
                    break;
            }
        }

    }

    private void startExerciseFirst(){
        _imageId.setValue(exercise.getImageId());
    }
    private void startExerciseSecond(){
        listExerciseSecond=exercise.getWordsExerciseSecond();
        listAnswersSecond=exercise.getWordsAnswersSecond();


    }
    private void startExerciseThird(){}

    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonImageAnswerClicked() {
        if (!answer.isEmpty()) {
            checkAnswerFirst(answer);
            showNextImage();
        } else {
            _showEmptyAnswerMessage.setValue(true);
        }
    }

    public void onButtonFirstAnswerClicked() {

    }

    public void onButtonSecondAnswerClicked() {

    }

    public void onButtonThirdAnswerClicked() {
    }

    public void onButtonFourthAnswerClicked() {
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);

    }


    public void checkAnswerFirst(String answer) {
        HashMap<String, Integer> editAnswer = exerciseRepository.getImageAnswers();
        boolean isAnswerCorrect = false;

        for (Map.Entry<String, Integer> str : editAnswer.entrySet()) {
            if (answer.equals(str.getKey())) {
                isAnswerCorrect = true;
                resultRepository.setResultFirst();
                break;
            }
        }
        _showAnswerResult.setValue(isAnswerCorrect);
    }

    private void showNextImage() {
        int index = exercises.indexOf(exercise);
        if (index < exercises.size() - 1) {
            exercise = exercises.get(index + 1);
            _imageId.setValue(exercise.getImageId());
        } else {
            _showFinishDialog.setValue(resultRepository.resultFirst.getValue());
        }
    }

    public void answerSecondExercise() {
        int i=0;
        int exerciseIndex = listExerciseSecond.indexOf(i);
        if (exerciseIndex <listExerciseSecond.size() - 1) {
            i = listExerciseSecond.get(exerciseIndex + 1);
            wordsExerciseSecond.setValue(i.getWordsExerciseSecond());
        } else {
            _showFinishDialog.setValue(resultRepository.resultFirst.getValue());
        }
        int answerIndex

    }

    public void answerThirdExercise() {

    }
}




package com.example.eng.ui.exercisefirst;

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

    int secondExerciseCurrentIndex = 0;
    int secondExerciseAnswerCurrentIndex = 0;

    private final MutableLiveData<String> _topicName = new MutableLiveData<>();
    LiveData<String> topicName = _topicName;

    private final MutableLiveData<String> _imageId = new MutableLiveData<>();
    LiveData<String> imageId = _imageId;

    private final MutableLiveData<String> _exerciseSecond = new MutableLiveData<>();
    LiveData<String> exerciseSecond = _exerciseSecond;
    private final MutableLiveData<List<String>> _exerciseSecondAnswers = new MutableLiveData<>();
    LiveData<List<String>> exerciseSecondAnswers = _exerciseSecondAnswers;

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
        resultRepository.clearResult(type);
        exercises = exerciseDAO.getAll(topicName.getValue(), type);
        if (!exercises.isEmpty()) {
            exercise = exercises.get(0);
            switch (type) {
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

    // First exercise

    private void startExerciseFirst() {
        _imageId.setValue(exercise.getImageId());
    }

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

    // Second exercise

    private void startExerciseSecond() {
        listExerciseSecond = exercise.getWordsExerciseSecond();
        listAnswersSecond = exercise.getWordsAnswersSecond();
        String exerciseSecond = listExerciseSecond.get(secondExerciseCurrentIndex);
        _exerciseSecond.setValue(exerciseSecond);

        List<String> answers = listAnswersSecond.subList(secondExerciseAnswerCurrentIndex, secondExerciseAnswerCurrentIndex + 4);
        _exerciseSecondAnswers.setValue(answers);
    }

    public void onButtonSecondExerciseClicked(String answer) {
        checkAnswerSecond(answer);
        showNextSecondExercise();
    }

    public void checkAnswerSecond(String answer) {
        // Проверка правильности ответа
        // Если ответ правильный, то
        // resultRepository.setResultSecond();
        // _showAnswerResult.setValue(isAnswerCorrect);
    }

    private void showNextSecondExercise() {
        if (secondExerciseCurrentIndex == listExerciseSecond.size() - 1) {
            _showFinishDialog.setValue(resultRepository.resultSecond.getValue());
        } else {
            secondExerciseCurrentIndex++;
            secondExerciseAnswerCurrentIndex += 4;
            String exerciseSecond = listExerciseSecond.get(secondExerciseCurrentIndex);
            _exerciseSecond.setValue(exerciseSecond);

            List<String> answers = listAnswersSecond.subList(secondExerciseAnswerCurrentIndex, secondExerciseAnswerCurrentIndex + 4);
            _exerciseSecondAnswers.setValue(answers);
        }
    }

    // Third exercise

    private void startExerciseThird() {
    }

    public void setTopicName(String topicName) {
        _topicName.setValue(topicName);

    }

    public void answerThirdExercise() {

    }
}




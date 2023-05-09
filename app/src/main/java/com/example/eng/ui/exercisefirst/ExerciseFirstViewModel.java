package com.example.eng.ui.exercisefirst;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.eng.R;
import com.example.eng.util.SingleLiveEvent;

import java.util.List;

public class ExerciseFirstViewModel extends ViewModel{
    private String answer;
    private ExerciseFirstDAO exerciseDAO;


    private SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;
    private SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    private MutableLiveData<String> _topicName=new MutableLiveData<>();
    LiveData<String> topicName=_topicName;

    private MutableLiveData<Integer> _imageId=new MutableLiveData<>();
    LiveData<Integer> imageId=_imageId;

    public ExerciseFirstViewModel(ExerciseFirstDAO exerciseDAO, SavedStateHandle savedStateHandle){
        String topicName=savedStateHandle.get("name");
        _topicName.setValue(topicName);
        this.exerciseDAO=exerciseDAO;
        List<Exercise> exercises = exerciseDAO.getAll(topicName);
        Exercise exercise = exercises.get(0);
        _imageId.setValue(exercise.getImageId());

    }



    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonFirstAnswerClicked() {}
    public void onButtonSecondAnswerClicked() {}
    public void onButtonThirdAnswerClicked() {}
    public void onButtonFourthAnswerClicked() {}
    public  void setText(){};
    public void onButtonTopicsClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }
    public void onButtonGoToSelectionTaskClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}



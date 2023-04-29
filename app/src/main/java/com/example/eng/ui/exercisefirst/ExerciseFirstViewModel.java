package com.example.eng.ui.exercisefirst;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.eng.util.SingleLiveEvent;

public class ExerciseFirstViewModel extends ViewModel{
    private String answer;

    private SingleLiveEvent<Boolean> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;
    private SingleLiveEvent<Boolean> _navigationToTopicSelectionFragment = new SingleLiveEvent<>();
    LiveData<Boolean> navigationToTopicSelectionFragment = _navigationToTopicSelectionFragment;

    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonTopicsClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }

    public void onButtonGoToTasksClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}



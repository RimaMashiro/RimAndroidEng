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

    static {
        //void insertAll(ArrayList<Exercise> exercises){};
    }

    public void onAnswerChanged(String answer) {
        this.answer = answer;
    }

    public void onButtonFirstAnswerClicked() {}
    public void onButtonSecondAnswerClicked() {}
    public void onButtonThirdAnswerClicked() {}
    public void onButtonFourthAnswerClicked() {}
    public void onButtonTopicsClicked() {
        _navigationToTopicSelectionFragment.setValue(true);
    }
    public void onButtonGoToSelectionTaskClicked() {
        _navigationToSelectionTaskFragment.setValue(true);
    }
}



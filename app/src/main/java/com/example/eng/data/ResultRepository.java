package com.example.eng.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.eng.ui.exercisefirst.ExerciseType;

import javax.inject.Inject;

public class ResultRepository {

    private SharedPreferencesManager sharedPreferencesManager;

    private MutableLiveData<Integer> _resultFirst = new MutableLiveData<>();
    public LiveData<Integer> resultFirst = _resultFirst;

    private MutableLiveData<Integer> _resultSecond = new MutableLiveData<>(0);
    public LiveData<Integer> resultSecond = _resultSecond;

    private MutableLiveData<Integer> _resultThird = new MutableLiveData<>(0);
    public LiveData<Integer> resultThird = _resultThird;

    @Inject
    public ResultRepository(SharedPreferencesManager sharedPreferencesManager) {
        this.sharedPreferencesManager = sharedPreferencesManager;
        _resultFirst.setValue(sharedPreferencesManager.getResultFirst());
        _resultSecond.setValue(sharedPreferencesManager.getResultSecond());
        _resultThird.setValue(sharedPreferencesManager.getResultThird());
    }

    public LiveData<Integer> getResultFirst() {
        return resultFirst;
    }

    public void setResultFirst() {
        int nextCount = _resultFirst.getValue();
        sharedPreferencesManager.setResultFirst(nextCount + 1);
        _resultFirst.setValue(sharedPreferencesManager.getResultFirst());
    }

    public LiveData<Integer> getResultSecond() {
        return resultSecond;
    }

    public void setResultSecond() {
        int nextCount = _resultSecond.getValue();
        sharedPreferencesManager.setResultSecond(nextCount + 1);
        _resultSecond.setValue(sharedPreferencesManager.getResultSecond());
    }

    public LiveData<Integer> getResultThird() {
        return resultThird;
    }

    public void setResultThird() {
        int nextCount = _resultThird.getValue();
        sharedPreferencesManager.setResultThird(nextCount + 1);
        _resultThird.setValue(sharedPreferencesManager.getResultThird());
    }

    public void clearResult(ExerciseType type) {
        switch (type) {
            case FIRST:
                _resultFirst.setValue(0);
                break;
            case SECOND:
                _resultSecond.setValue(0);
                break;
            default:
                _resultThird.setValue(0);
                break;
        }
    }
}

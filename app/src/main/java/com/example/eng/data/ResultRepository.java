package com.example.eng.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.eng.ui.exercisefirst.ExerciseType;

import android.util.Log;
import javax.inject.Inject;

public class ResultRepository {

    private MutableLiveData<Integer> _countFirst = new MutableLiveData<>(0);
    public LiveData<Integer> countFirst = _countFirst;

    private MutableLiveData<Integer> _countSecond = new MutableLiveData<>(0);
    public LiveData<Integer> countSecond = _countSecond;

    private MutableLiveData<Integer> _countThird = new MutableLiveData<>(0);
    public LiveData<Integer> countThird = _countThird;

    @Inject
    public ResultRepository() {
    }

    public LiveData<Integer> getCountFirst() {
        return countFirst;
    }

    public void setCountFirst() {
        int nextCount = _countFirst.getValue();
        _countFirst.setValue(nextCount + 1);
    }

    public LiveData<Integer> getCountSecond() {
        return countSecond;
    }

    public void setCountSecond() {
        int nextCount = _countSecond.getValue();
        _countSecond.setValue(nextCount + 1);
    }

    public LiveData<Integer> getCountThird() {
        return countThird;
    }

    public void setCountThird() {
        int nextCount = _countThird.getValue();
        _countThird.setValue(nextCount + 1);
    }

    public void clearResult(ExerciseType type) {
        switch (type) {
            case FIRST:
                _countFirst.setValue(0);
                break;
            case SECOND:
                _countSecond.setValue(0);
                break;
            default:
                _countThird.setValue(0);
                break;
        }
    }
}

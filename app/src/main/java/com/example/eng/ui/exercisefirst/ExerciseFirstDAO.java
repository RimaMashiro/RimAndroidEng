package com.example.eng.ui.exercisefirst;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.eng.ui.dictionary.Dictionary;

import java.util.List;

@Dao
public interface ExerciseFirstDAO {

    @Insert
    void insertAll(List<Exercise> exercises);

    @Query("SELECT* FROM Exercises WHERE topicName=:topicName AND exerciseType=:exerciseType")
    List<Exercise> getAll(String topicName, ExerciseType exerciseType);

    @Query("SELECT* FROM Exercises ")
    List<Exercise> getAll();

}

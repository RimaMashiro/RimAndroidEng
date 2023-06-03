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

    @Query("SELECT* FROM Exercises WHERE topicName=:topicName")
    List<Exercise> getAll(String topicName);

    @Query("SELECT* FROM Exercises ")
    Exercise getAll();
}

package com.example.eng.ui.exercisefirst;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.eng.ui.topicselection.Topic;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExerciseFirstDAO {

    @Insert
    void insertAll(List<Exercise> exercises);
    @Query("SELECT * FROM Exercises")
    List<Exercise> getAll();


}

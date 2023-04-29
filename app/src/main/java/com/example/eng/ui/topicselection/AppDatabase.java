package com.example.eng.ui.topicselection;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;

@Database(entities = {Topic.class}, version = 1)
public abstract class  AppDatabase extends RoomDatabase {
    public  abstract TopicDAO getTopicDao();

}

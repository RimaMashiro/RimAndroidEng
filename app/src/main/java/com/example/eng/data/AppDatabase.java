package com.example.eng.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicDAO;

@Database(entities = {Topic.class}, version = 1)
public abstract class  AppDatabase extends RoomDatabase {
    public static String databaseName= "EngDatabase";
    public  abstract TopicDAO getTopicDao();
}

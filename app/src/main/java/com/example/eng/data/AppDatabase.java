package com.example.eng.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.grammar.Grammar;
import com.example.eng.ui.grammar.GrammarDAO;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicDAO;

@Database(entities = {Topic.class, Grammar.class}, version = 2)
public abstract class  AppDatabase extends RoomDatabase {
    public static String databaseName= "EngDatabase";
    public  abstract TopicDAO getTopicDao();
    public  abstract GrammarDAO getGrammarDao();
}

package com.example.eng.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eng.ui.exercisefirst.Exercise;
import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.grammar.Grammar;
import com.example.eng.ui.grammar.GrammarDAO;
import com.example.eng.ui.selectiontask.SelectionTask;
import com.example.eng.ui.selectiontask.SelectionTaskDAO;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicDAO;

@Database(entities = {Topic.class, Grammar.class, SelectionTask.class, Exercise.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public static String databaseName = "EngDatabase";

    public abstract TopicDAO getTopicDao();

    public abstract GrammarDAO getGrammarDao();

    public abstract SelectionTaskDAO getSelectionTaskDao();

    public abstract ExerciseFirstDAO getExerciseFirstDao();
}

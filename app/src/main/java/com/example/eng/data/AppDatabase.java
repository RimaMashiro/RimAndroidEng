package com.example.eng.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.eng.ui.dictionary.Dictionary;
import com.example.eng.ui.dictionary.DictionaryDAO;
import com.example.eng.ui.dictionary.WordsConvertor;
import com.example.eng.ui.exercisefirst.Exercise;
import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.grammar.Grammar;
import com.example.eng.ui.grammar.GrammarDAO;
import com.example.eng.ui.selectiontask.SelectionTask;
import com.example.eng.ui.selectiontask.SelectionTaskDAO;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicDAO;

@Database(entities = {Topic.class, Grammar.class, SelectionTask.class, Dictionary.class, Exercise.class}, version = 6)
@TypeConverters({WordsConvertor.class})
public abstract class  AppDatabase extends RoomDatabase {
    public static String databaseName= "EngDatabase";
    public  abstract TopicDAO getTopicDao();
    public  abstract GrammarDAO getGrammarDao();
    public  abstract SelectionTaskDAO getSelectionTaskDao();
    public abstract DictionaryDAO getDictionaryDao();
    public abstract ExerciseFirstDAO getExerciseFirstDao();


}

package com.example.eng.ui.grammar;

import androidx.room.Database;

import com.example.eng.ui.grammar.GrammarViewModel;

@Database(entities = {Topic.class}, version = 1)
public abstract class  AppDatabase {
    public  abstract TopicDAO getTopicDao();
}

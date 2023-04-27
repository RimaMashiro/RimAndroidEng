package com.example.eng.ui.topicselection;

import androidx.room.Database;
@Database(entities = {Topic.class}, version = 1)
public abstract class  AppDatabase {
    public  abstract TopicDAO getTopicDao();
}

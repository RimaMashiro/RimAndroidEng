package com.example.eng.di;

import android.content.Context;

import androidx.room.Room;

import com.example.eng.ui.topicselection.AppDatabase;
import com.example.eng.ui.topicselection.TopicDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {
    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.databaseName).allowMainThreadQueries().build();

    }

    @Provides
    @Singleton
    public TopicDAO provideTopicDAO(AppDatabase database){
        return database.getTopicDao();
    }


}

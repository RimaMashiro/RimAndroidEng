package com.example.eng.di;

import android.content.Context;

import androidx.room.Room;

import com.example.eng.data.AppDatabase;
import com.example.eng.ui.dictionary.DictionaryDAO;
import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.grammar.GrammarDAO;
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
    public AppDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.databaseName).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    public TopicDAO provideTopicDAO(AppDatabase database) {
        return database.getTopicDao();
    }

    @Provides
    @Singleton
    public GrammarDAO provideGrammarDAO(AppDatabase database) {
        return database.getGrammarDao();
    }

    @Provides
    @Singleton
    public ExerciseFirstDAO provideExerciseFirstDAO(AppDatabase database) {
        return database.getExerciseFirstDao();
    }

    @Provides
    @Singleton
    public DictionaryDAO provideDictionaryDAO(AppDatabase database) {
        return database.getDictionaryDao();
    }
}

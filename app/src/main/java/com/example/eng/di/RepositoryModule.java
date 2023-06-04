package com.example.eng.di;

import com.example.eng.data.ResultRepository;
import com.example.eng.data.SharedPreferencesManager;
import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.exercisefirst.ExerciseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public ExerciseRepository provideExerciseRepository(ExerciseFirstDAO exerciseFirstDAO){
        return  new ExerciseRepository(exerciseFirstDAO);
    }
    @Provides
    @Singleton
    public ResultRepository provideResultRepository(SharedPreferencesManager sharedPreferencesManager){
        return  new ResultRepository(sharedPreferencesManager);
    }
}

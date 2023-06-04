package com.example.eng.di;

import com.example.eng.data.SharedPreferencesManager;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public class SharedPreferencesModule {

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
        return context.getSharedPreferences(SharedPreferencesManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}

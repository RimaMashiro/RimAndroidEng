package com.example.eng.data;

import android.content.SharedPreferences;
import javax.inject.Inject;

public class SharedPreferencesManager {
    public static String SHARED_PREFERENCES_NAME = "eng_shared_preferences";
    private final String KEY_IS_FIRST_LAUNCH = "is_first_launch";
    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean checkIsFirstLaunch() {
        return sharedPreferences.getBoolean(KEY_IS_FIRST_LAUNCH, true);
    }

    public void setIsFirstLaunch() {
        sharedPreferences.edit().putBoolean(KEY_IS_FIRST_LAUNCH, false).apply();
    }
}

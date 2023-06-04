package com.example.eng.data;

import android.content.SharedPreferences;
import javax.inject.Inject;

public class SharedPreferencesManager {
    public static String SHARED_PREFERENCES_NAME = "eng_shared_preferences";
    private final String KEY_IS_FIRST_LAUNCH = "is_first_launch";

    private final String KEY_RESULT_FIRST = "result_first";
    private final String KEY_RESULT_SECOND = "result_second";
    private final String KEY_RESULT_THIRD = "result_third";

    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean checkIsFirstLaunch() {//проверка первый запуск
        return sharedPreferences.getBoolean(KEY_IS_FIRST_LAUNCH, true);
    }

    public void setIsFirstLaunch() {
        sharedPreferences.edit().putBoolean(KEY_IS_FIRST_LAUNCH, false).apply();
    }

    public int getResultFirst() {
        return sharedPreferences.getInt(KEY_RESULT_FIRST, 0);
    }

    public void setResultFirst(int resultFirst) {
        sharedPreferences.edit().putInt(KEY_RESULT_FIRST, resultFirst).apply();
    }

    public int getResultSecond() {
        return sharedPreferences.getInt(KEY_RESULT_SECOND, 0);
    }

    public void setResultSecond(int resultSecond) {
        sharedPreferences.edit().putInt(KEY_RESULT_SECOND, resultSecond).apply();
    }

    public int getResultThird() {
        return sharedPreferences.getInt(KEY_RESULT_THIRD, 0);
    }

    public void setResultThird(int resultThird) {
        sharedPreferences.edit().putInt(KEY_RESULT_THIRD, resultThird).apply();
    }
}

package com.example.eng.ui.dictionary;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class WordsConvertor {
    @TypeConverter
    public static String fromList(List<String> words) {
        return String.join(",", words);
    }

    @TypeConverter
    public static List<String> stringToList(String res) {
        return Arrays.asList(res.split(",", -1));
    }
}
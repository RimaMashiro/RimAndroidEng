package com.example.eng.ui.dictionary;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;


public class WordsConvertor {
    @TypeConverter
    public static String fromList(List<String> words) {

        String delim = "-";
        String res = String.join(delim, words);
        return res;
    }

    @TypeConverter
    public static List<String> stringToList(String res) {
        List<String> convertedList = Arrays.asList(res.split(",", -1));
        return convertedList;
    }
}
package com.example.eng.ui.exercisefirst;

import com.example.eng.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

public class ExerciseRepository {

    private HashMap<String, Integer> imageAnswers = getImageAnswers();
    ExerciseFirstDAO exerciseFirstDAO;

    @Inject
    public ExerciseRepository(ExerciseFirstDAO exerciseFirstDAO) {
        this.exerciseFirstDAO = exerciseFirstDAO;
    }

    public HashMap<String, Integer> getImageAnswers() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("bird", R.drawable.bird);
        hashMap.put("cat", R.drawable.cat);
        hashMap.put("egg", R.drawable.eag);
        hashMap.put("card", R.drawable.card);
        hashMap.put("heaven", R.drawable.heaven);
        return hashMap;
    }
}

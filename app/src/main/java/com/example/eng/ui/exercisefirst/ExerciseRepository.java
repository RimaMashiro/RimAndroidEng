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
        exerciseFirstDAO.insertAll(getExerciseList());
    }

    public HashMap<String, Integer> getImageAnswers() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("bird", R.drawable.bird);
        hashMap.put("cat", R.drawable.cat);
        hashMap.put("eag", R.drawable.eag);
        hashMap.put("card", R.drawable.card);
        hashMap.put("heaven", R.drawable.heaven);
        return hashMap;
    }

    public ArrayList<Exercise> getExerciseList() {

        ArrayList<Exercise> exercises = new ArrayList<>();
        String[] wordEn1 = new String[]{"bird", "heaven", "eag", "card", "cat"};//слва к которым нужно найти перевод
        String[] wordRu1 = new String[]{"птица", "небо", "яйцо", "карта", "кошка"};
        String[] wordEngEx1 = new String[]{"bird", "heaven", "eag", "card", "cat", "bird", "heaven", "eag", "card", "cat", "bird", "heaven", "eag", "card", "cat", "bird", "heaven"};
        String[] wordRusEx1 = new String[]{"птица", "небо", "яйцо", "карта", "кошка", "птица", "небо", "яйцо", "карта", "кошка", "птица", "яйцо", "карта", "кошка", "птица", "небо", "яйцо", "карта", "кошка", "небо"};
        List<String> wordEnglish1 = Arrays.asList(wordEn1);
        List<String> wordRussian1 = Arrays.asList(wordRu1);
        List<String> wordEng1 = Arrays.asList(wordEngEx1);
        List<String> wordRus1 = Arrays.asList(wordRusEx1);
        exercises.add(new Exercise(UUID.randomUUID().toString(), R.drawable.bird, ExerciseType.FIRST, "Topic1", wordEnglish1, wordRussian1, wordEng1, wordRus1));
        return exercises;
    }
}

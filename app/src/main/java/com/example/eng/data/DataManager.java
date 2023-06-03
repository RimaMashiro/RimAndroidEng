package com.example.eng.data;

import com.example.eng.ui.dictionary.Dictionary;
import com.example.eng.ui.dictionary.DictionaryDAO;
import com.example.eng.ui.exercisefirst.Exercise;
import com.example.eng.ui.exercisefirst.ExerciseFirstDAO;
import com.example.eng.ui.exercisefirst.ExerciseType;
import com.example.eng.ui.grammar.Grammar;
import com.example.eng.ui.grammar.GrammarDAO;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {
    private TopicDAO topicDAO;
    private GrammarDAO grammarDAO;
    private DictionaryDAO dictionaryDAO;
    private ExerciseFirstDAO exerciseFirstDAO;

    @Inject
    public DataManager(
            TopicDAO topicDAO,
            GrammarDAO grammarDAO,
            DictionaryDAO dictionaryDAO,
            ExerciseFirstDAO exerciseFirstDAO
    ) {
        this.topicDAO = topicDAO;
        this.grammarDAO = grammarDAO;
        this.dictionaryDAO = dictionaryDAO;
        this.exerciseFirstDAO = exerciseFirstDAO;
    }

    public void addData() {
        dictionaryDAO.insertAll(getDictionaryList());
        exerciseFirstDAO.insertAll(getExerciseList());
        grammarDAO.insertAll(getGrammarList());
        topicDAO.insertAll(getTopicList());
    }

    public ArrayList<Dictionary> getDictionaryList() {
        ArrayList<Dictionary> dictionary = new ArrayList<>();
        String[] wordEn = new String[]{"bird", "heaven", "egg", "card", "cat"};
        String[] wordRu = new String[]{"птица", "небо", "яйцо", "карта", "кошка"};
        List<String> wordEng = Arrays.asList(wordEn);
        List<String> wordRus = Arrays.asList(wordRu);
        dictionary.add(new Dictionary(wordEng, wordRus, "Инфинитив"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Глаголы to be"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic3"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic4"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic5"));
        return dictionary;
    }

    public ArrayList<Exercise> getExerciseList() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        String[] wordEn1 = new String[]{"bird", "heaven", "egg", "card", "cat"};//слва к которым нужно найти перевод
        String[] wordRu1 = new String[]{"птица", "небо", "яйцо", "карта", "кошка"};
        String[] wordEngEx1 = new String[]{"bird", "heaven", "egg", "card", "cat", "bird", "heaven", "egg", "card", "cat", "bird", "heaven", "egg", "card", "cat", "bird", "heaven"};
        String[] wordRusEx1 = new String[]{"птица", "небо", "яйцо", "карта", "кошка", "птица", "небо", "яйцо", "карта", "кошка", "птица", "яйцо", "карта", "кошка", "птица", "небо", "яйцо", "карта", "кошка", "небо"};
        List<String> wordEnglish1 = Arrays.asList(wordEn1);
        List<String> wordRussian1 = Arrays.asList(wordRu1);
        List<String> wordEng1 = Arrays.asList(wordEngEx1);
        List<String> wordRus1 = Arrays.asList(wordRusEx1);

        exercises.add(new Exercise(UUID.randomUUID().toString(), "bird", ExerciseType.FIRST, "Инфинитив", wordEnglish1, wordRussian1, wordEng1, wordRus1));
        exercises.add(new Exercise(UUID.randomUUID().toString(), "eag", ExerciseType.FIRST, "Инфинитив", wordEnglish1, wordRussian1, wordEng1, wordRus1));
        exercises.add(new Exercise(UUID.randomUUID().toString(), "card", ExerciseType.FIRST, "Инфинитив", wordEnglish1, wordRussian1, wordEng1, wordRus1));
        exercises.add(new Exercise(UUID.randomUUID().toString(), "heaven", ExerciseType.FIRST, "Инфинитив", wordEnglish1, wordRussian1, wordEng1, wordRus1));
        exercises.add(new Exercise(UUID.randomUUID().toString(), "cat", ExerciseType.FIRST, "Инфинитив", wordEnglish1, wordRussian1, wordEng1, wordRus1));

        return exercises;
    }

    public ArrayList<Grammar> getGrammarList() {
        ArrayList<Grammar> grammars = new ArrayList<>();
        grammars.add(new Grammar("Инфинитив в английском языке представляет собой неличную форму английского глагола, которая обозначает только действие, не указывая ни лица, ни числа. Инфинитив отвечает на вопросы: что делать? что сделать?\n" +"to read – читать\n" +
                "to speak – говорить \n"+"В русском языке инфинитив чаще называют неопределённой формой глагола. Именно инфинитив приводится в словарях, как начальная форма глагола.\n" +
                "\n" +
                "Формальным признаком инфинитива в английском языке является частица to, которая перед инфинитивом в некоторых случаях опускается." +
                "", "Инфинитив"));
        return grammars;
    }

    public ArrayList<Topic> getTopicList() {
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Инфинитив"));
        topics.add(new Topic("Глагол to be "));
        topics.add(new Topic("Простое настоящее время"));
        topics.add(new Topic("Простое прошедшее время"));
        topics.add(new Topic("Модальный глагол Can"));
        return topics;
    }
}

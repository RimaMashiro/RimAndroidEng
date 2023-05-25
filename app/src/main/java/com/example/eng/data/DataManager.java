package com.example.eng.data;

import com.example.eng.R;
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
        addData();
    }

    public void addData() {
        dictionaryDAO.insertAll(getDictionaryList());
        exerciseFirstDAO.insertAll(getExerciseList());
        grammarDAO.insertAll(getGrammarList());
        topicDAO.insertAll(getTopicList());
    }

    public ArrayList<Dictionary> getDictionaryList() {
        ArrayList<Dictionary> dictionary = new ArrayList<>();
        String[] wordEn = new String[]{"word", "write"};
        String[] wordRu = new String[]{"слово", "писать"};
        List<String> wordEng = Arrays.asList(wordEn);
        List<String> wordRus = Arrays.asList(wordRu);

        dictionary.add(new Dictionary(wordEng, wordRus, "Topic1"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic2"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic3"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic4"));
        dictionary.add(new Dictionary(wordEng, wordRus, "Topic5"));
        return dictionary;
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

    public ArrayList<Grammar> getGrammarList() {
        ArrayList<Grammar> grammars = new ArrayList<>();
        // реализовать добавление грамматики
        return grammars;
    }

    public ArrayList<Topic> getTopicList() {
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Topic1"));
        topics.add(new Topic("Topic2"));
        topics.add(new Topic("Topic3"));
        topics.add(new Topic("Topic4"));
        topics.add(new Topic("Topic5"));
        return topics;
    }
}

package com.example.eng.ui.dictionary;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "Dictionaries")
public class Dictionary {

    @PrimaryKey
    @NonNull
    private String topicName;
    private List<String> wordsEng;
    private List<String> wordsRus;


    public Dictionary(List<String> wordsEng, List<String> wordsRus, String topicName) {
        this.wordsEng = wordsEng;
        this.wordsRus = wordsRus;
        this.topicName = topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return topicName.equals(that.topicName) && Objects.equals(wordsEng, that.wordsEng) && Objects.equals(wordsRus, that.wordsRus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicName, wordsEng, wordsRus);
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "topicName='" + topicName + '\'' +
                ", wordsEng=" + wordsEng +
                ", wordsRus=" + wordsRus +
                '}';
    }

    @NonNull
    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(@NonNull String topicName) {
        this.topicName = topicName;
    }

    public List<String> getWordsEng() {
        return this.wordsEng;
    }

    public void setWordsEng(List<String> wordsEng) {
        this.wordsEng = wordsEng;
    }

    public List<String> getWordsRus() {
        return this.wordsRus;
    }

    public void setWordsRus(List<String> wordsRus) {
        this.wordsRus = wordsRus;
    }
}


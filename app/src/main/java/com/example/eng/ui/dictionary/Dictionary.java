package com.example.eng.ui.dictionary;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.eng.ui.exercisefirst.ExerciseType;

import java.util.List;

@Entity(tableName = "Dictionaries")

public class Dictionary {

        @PrimaryKey
        @NonNull
        private String topicName;

        private List<String> wordsEng;
        private List<String> wordsRus;


        public Dictionary(  List<String> wordsEng, List<String> wordsRus, String topicName){
            this.wordsEng=wordsEng;
            this.wordsRus=wordsRus;
            this.topicName=topicName;
        }

        public String getTopicName() {
            return this.topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    public List<String> getWordsEng(){return  this.wordsEng;}
    public List<String> getWordsRus(){return this.wordsRus;}



}


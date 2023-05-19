package com.example.eng.ui.exercisefirst;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Exercises")

public class Exercise {
    @PrimaryKey
    private String id; // название

    private int imageId;
    private String topicName;
    private List<String> wordsEnglish;
    private List<String> wordsRussians;
    private List<String> wordsEngRight;
    private List<String> wordsRusRight;
    private ExerciseType exerciseType;


    public Exercise(String id, int imageId,String topicName, List<String> wordsEnglish, List<String> wordsRussians, ExerciseType exerciseType, List<String> wordsEngRight, List<String> wordsRusRight ){

        this.id=id;
        this.imageId=imageId;
        this.topicName=topicName;
        this.wordsEnglish=wordsEnglish;
        this.wordsRussians=wordsRussians;
        this.exerciseType=exerciseType;
        this.wordsEngRight=wordsEngRight;
        this.wordsRusRight=wordsRusRight;

    }

    public String getId() {
        return this.id;
    }
    public int getImageId() {
        return this.imageId;
    }
    public String getTopicName(){return this.topicName;}
    public List<String> getWordsEnglish(){return  this.wordsEnglish;}
    public List<String> getWordsRussians(){return this.wordsRussians;}
    public List<String> getWordsEngRight(){return this.wordsEngRight;}
    public List<String> getWordsRusRight(){return  this.wordsRusRight;}
    public ExerciseType getExerciseType(){return  this.exerciseType;}


    public void setId(String id) {
        this.id = id;
    }

}

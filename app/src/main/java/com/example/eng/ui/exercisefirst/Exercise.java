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
    private ExerciseType exerciseType;


    public Exercise(String id, int imageId, List<String> wordsEnglish, List<String> wordsRussians, ExerciseType exerciseType ){

        this.id=id;
        this.imageId=imageId;
        this.wordsEnglish=wordsEnglish;
        this.wordsRussians=wordsRussians;
        this.exerciseType=exerciseType;

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
    public ExerciseType getExerciseType(){return  this.exerciseType;}


    public void setId(String id) {
        this.id = id;
    }

}

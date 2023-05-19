package com.example.eng.ui.exercisefirst;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Exercises")
public class Exercise {
    @PrimaryKey
    @NonNull
    private String id; // название

    private int imageId;
    private String topicName;
    //    private List<String> wordsEnglish;
//    private List<String> wordsRussians;
    private ExerciseType exerciseType;

    public Exercise(String id, int imageId, ExerciseType exerciseType) {
        this.id = id;
        this.imageId = imageId;
//        this.wordsEnglish = wordsEnglish;
//        this.wordsRussians = wordsRussians;
        this.exerciseType = exerciseType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    //    public List<String> getWordsEnglish() {
//        return this.wordsEnglish;
//    }
//
//    public List<String> getWordsRussians() {
//        return this.wordsRussians;
//    }
//
    public ExerciseType getExerciseType() {
        return this.exerciseType;
    }
}

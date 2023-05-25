package com.example.eng.ui.exercisefirst;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "Exercises")
public class Exercise {

    @PrimaryKey
    @NonNull
    private String id; // название

    private int imageId;
    private String topicName;
    private List<String> wordsEnglish;
    private List<String> wordsRussians;
    private List<String> wordEngExercise;
    private List<String> wordRusExercise;
    private ExerciseType exerciseType;

    public Exercise(
            String id,
            int imageId,
            ExerciseType exerciseType,
            String topicName,
            List<String> wordsEnglish,
            List<String> wordsRussians,
            List<String> wordEngExercise,
            List<String> wordRusExercise
    ) {
        this.id = id;
        this.imageId = imageId;
        this.wordsEnglish = wordsEnglish;
        this.wordsRussians = wordsRussians;
        this.wordEngExercise = wordEngExercise;
        this.wordRusExercise = wordRusExercise;
        this.exerciseType = exerciseType;
        this.topicName = topicName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageId, topicName, wordsEnglish, wordsRussians, wordEngExercise, wordRusExercise, exerciseType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return imageId == exercise.imageId &&
                id.equals(exercise.id) &&
                Objects.equals(topicName, exercise.topicName) &&
                Objects.equals(wordsEnglish, exercise.wordsEnglish) &&
                Objects.equals(wordsRussians, exercise.wordsRussians) &&
                Objects.equals(wordEngExercise, exercise.wordEngExercise) &&
                Objects.equals(wordRusExercise, exercise.wordRusExercise) &&
                exerciseType == exercise.exerciseType;
    }

    @Override
    public String toString() {
        return "Exercise{" + "id='" + id + '\'' + ", imageId=" + imageId + ", topicName='" + topicName + '\'' + ", wordsEnglish=" + wordsEnglish + ", wordsRussians=" + wordsRussians + ", wordEngExercise=" + wordEngExercise + ", wordRusExercise=" + wordRusExercise + ", exerciseType=" + exerciseType + '}';
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

    public List<String> getWordsEnglish() {
        return this.wordsEnglish;
    }

    public void setWordsEnglish(List<String> wordsEnglish) {
        this.wordsEnglish = wordsEnglish;
    }

    public List<String> getWordsRussians() {
        return this.wordsRussians;
    }

    public void setWordsRussians(List<String> wordsRussians) {
        this.wordsRussians = wordsRussians;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public ExerciseType getExerciseType() {
        return this.exerciseType;
    }

    public List<String> getWordEngExercise() {
        return wordEngExercise;
    }

    public void setWordEngExercise(List<String> wordEngExercise) {
        this.wordEngExercise = wordEngExercise;
    }

    public List<String> getWordRusExercise() {
        return wordRusExercise;
    }

    public void setWordRusExercise(List<String> wordRusExercise) {
        this.wordRusExercise = wordRusExercise;
    }
}

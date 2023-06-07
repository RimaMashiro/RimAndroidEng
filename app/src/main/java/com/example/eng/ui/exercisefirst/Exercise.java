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

    private String imageId;
    private String topicName;
    private List<String> wordsExerciseSecond;
    private List<String> wordsAnswersSecond;
    private List<String> wordsExerciseThird;
    private List<String> wordsAnswersThird;
    private ExerciseType exerciseType;

    public Exercise(
            String id,
            String imageId,
            ExerciseType exerciseType,
            String topicName,
            List<String> wordsExerciseSecond,
            List<String> wordsAnswersSecond,
            List<String> wordsExerciseThird,
            List<String> wordsAnswersThird
    ) {
        this.id = id;
        this.imageId = imageId;
        this.wordsExerciseSecond = wordsExerciseSecond;
        this.wordsAnswersSecond = wordsAnswersSecond;
        this.wordsExerciseThird = wordsExerciseThird;
        this.wordsAnswersThird = wordsAnswersThird;
        this.exerciseType = exerciseType;
        this.topicName = topicName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageId, topicName, wordsExerciseSecond, wordsAnswersSecond, wordsExerciseThird, wordsAnswersThird, exerciseType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return imageId == exercise.imageId &&
                id.equals(exercise.id) &&
                Objects.equals(topicName, exercise.topicName) &&
                Objects.equals(wordsExerciseSecond, exercise.wordsExerciseSecond) &&
                Objects.equals(wordsAnswersSecond, exercise.wordsAnswersSecond) &&
                Objects.equals(wordsExerciseThird, exercise.wordsExerciseThird) &&
                Objects.equals(wordsAnswersThird, exercise.wordsAnswersThird) &&
                exerciseType == exercise.exerciseType;
    }

    @Override
    public String toString() {
        return "Exercise{" + "id='" + id + '\'' + ", imageId=" + imageId + ", topicName='" + topicName + '\'' + ", wordsEnglish=" + wordsExerciseSecond + ", wordsRussians=" + wordsAnswersSecond + ", wordEngExercise=" + wordsExerciseThird + ", wordRusExercise=" + wordsAnswersThird + ", exerciseType=" + exerciseType + '}';
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageId() {
        return this.imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<String> getWordsExerciseSecond() {
        return this.wordsExerciseSecond;
    }

    public void setWordsExerciseSecond(List<String> wordsExerciseSecond) {
        this.wordsExerciseSecond = wordsExerciseSecond;
    }

    public List<String> getWordsAnswersSecond() {
        return this.wordsAnswersSecond;
    }

    public void setWordsAnswersSecond(List<String> wordsAnswersSecond) {
        this.wordsAnswersSecond = wordsAnswersSecond;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public ExerciseType getExerciseType() {
        return this.exerciseType;
    }

    public List<String> getWordsExerciseThird() {
        return wordsExerciseThird;
    }

    public void setWordsExerciseThird(List<String> wordsExerciseThird) {
        this.wordsExerciseThird = wordsExerciseThird;
    }

    public List<String> getWordsAnswersThird() {
        return wordsAnswersThird;
    }

    public void setWordsAnswersThird(List<String> wordsAnswersThird) {
        this.wordsAnswersThird = wordsAnswersThird;
    }
}

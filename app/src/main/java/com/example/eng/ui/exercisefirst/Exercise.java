package com.example.eng.ui.exercisefirst;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercises")

public class Exercise {
    @PrimaryKey
    private String id; // название

    public Exercise(String id){

        this.id=id;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

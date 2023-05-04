package com.example.eng.ui.topicselection;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Topics")
public class Topic {

    @PrimaryKey
    @NonNull
    private String name; // название

    public Topic(String name){
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
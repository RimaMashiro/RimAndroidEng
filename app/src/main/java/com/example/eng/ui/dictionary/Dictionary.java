package com.example.eng.ui.dictionary;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Dictionaries")

public class Dictionary {

        @PrimaryKey
        @NonNull
        private String name; // название

        public Dictionary(String name){
            this.name=name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


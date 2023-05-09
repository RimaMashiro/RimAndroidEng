package com.example.eng.ui.grammar;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Grammars")
public class Grammar {
    @PrimaryKey
    @NonNull
    String name;
    String topicName;
    String topicGrammar;
}

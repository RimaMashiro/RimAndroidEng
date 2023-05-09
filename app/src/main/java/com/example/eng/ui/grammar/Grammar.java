package com.example.eng.ui.grammar;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Grammars")
public class Grammar {
    @PrimaryKey
    String name;
    String topicName;
    String topicGrammar;
}

package com.example.eng.ui.grammar;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Grammars")
public class Grammar {
    @PrimaryKey
    @NonNull
    String topicName;
    String topicGrammar;
    public Grammar(String topicGrammar, String topicName){
        this.topicName=topicName;
        this.topicGrammar=topicGrammar;
    }
    public String getTopicGrammar() {
        return this.topicGrammar;
    }
}

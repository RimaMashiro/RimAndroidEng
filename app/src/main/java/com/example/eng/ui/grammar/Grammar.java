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

    @NonNull
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(@NonNull String topicName) {
        this.topicName = topicName;
    }

    public void setTopicGrammar(String topicGrammar) {
        this.topicGrammar = topicGrammar;
    }

    public String getTopicGrammar() {
        return this.topicGrammar;
    }
}

package com.example.eng.ui.grammar;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "Grammars")
public class Grammar {

    @PrimaryKey
    @NonNull
    String topicName;
    String topicGrammar;

    public Grammar(String topicGrammar, String topicName) {
        this.topicName = topicName;
        this.topicGrammar = topicGrammar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicName, topicGrammar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grammar grammar = (Grammar) o;
        return topicName.equals(grammar.topicName) && Objects.equals(topicGrammar, grammar.topicGrammar);
    }

    @Override
    public String toString() {
        return "Grammar{" +
                "topicName='" + topicName + '\'' +
                ", topicGrammar='" + topicGrammar + '\'' +
                '}';
    }

    @NonNull
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(@NonNull String topicName) {
        this.topicName = topicName;
    }

    public String getTopicGrammar() {
        return this.topicGrammar;
    }

    public void setTopicGrammar(String topicGrammar) {
        this.topicGrammar = topicGrammar;
    }
}

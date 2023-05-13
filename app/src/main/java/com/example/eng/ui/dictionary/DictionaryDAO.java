package com.example.eng.ui.dictionary;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.eng.ui.grammar.Grammar;

import java.util.List;

public interface DictionaryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Grammar> grammars);

    @Query("SELECT* FROM Grammars WHERE topicName=:topicName")
    LiveData<Grammar> getAll(String topicName);
}

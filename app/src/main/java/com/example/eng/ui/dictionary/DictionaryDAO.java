package com.example.eng.ui.dictionary;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DictionaryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Dictionary> dictionary);

    @Query("SELECT* FROM Dictionaries WHERE topicName =:topicName")
    Dictionary getAll(String topicName);
}

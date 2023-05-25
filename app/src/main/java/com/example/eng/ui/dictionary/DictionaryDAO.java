package com.example.eng.ui.dictionary;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.eng.ui.grammar.Grammar;

import java.util.List;

@Dao
public interface DictionaryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Dictionary> dictionary);

    @Query("SELECT* FROM Dictionaries ")
    Dictionary getAll();
}

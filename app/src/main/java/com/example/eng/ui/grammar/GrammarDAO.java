package com.example.eng.ui.grammar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface GrammarDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Grammar> grammars);

    @Query("SELECT * FROM Grammars")
    List<Grammar> getAll();
}

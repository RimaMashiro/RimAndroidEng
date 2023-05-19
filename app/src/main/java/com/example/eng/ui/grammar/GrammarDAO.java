package com.example.eng.ui.grammar;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface GrammarDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Grammar> grammar);

    @Query("SELECT* FROM Grammars WHERE topicName=:topicName")

    LiveData<Grammar>getAll(String topicName);


}

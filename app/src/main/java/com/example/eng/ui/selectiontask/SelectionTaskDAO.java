package com.example.eng.ui.selectiontask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SelectionTaskDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SelectionTask> tasks);

    @Query("SELECT* FROM Grammars WHERE topicName=:topicName")
    LiveData<SelectionTask> getAll(String topicName);
}

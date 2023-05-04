package com.example.eng.ui.topicselection;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TopicDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Topic> topics);
    @Query("SELECT * FROM Topics")
    LiveData<List<Topic>> getAll();
}

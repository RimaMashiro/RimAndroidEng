package com.example.eng.ui.topicselection;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TopicDAO {
    @Insert
    void insertAll(ArrayList<Topic> topics);
    @Query("SELECT * FROM Topics")
    List<Topic> getAll();
}

package com.example.eng.ui.grammar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.eng.ui.topicselection.Topic;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GrammarDAO {
    @Insert
    void insertAll(ArrayList<Topic> topics);
    @Query("SELECT * FROM Topics")
    List<Topic> getAll();






}

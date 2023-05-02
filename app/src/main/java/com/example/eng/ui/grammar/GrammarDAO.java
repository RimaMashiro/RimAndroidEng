package com.example.eng.ui.grammar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.eng.ui.topicselection.Topic;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface GrammarDAO {
    @Insert
    void insertAll(ArrayList<Grammar> grammars);
    @Query("SELECT * FROM Grammars")
    List<Grammar> getAll();






}

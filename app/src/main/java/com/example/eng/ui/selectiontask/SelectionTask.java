package com.example.eng.ui.selectiontask;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tasks")
public class SelectionTask {

    @PrimaryKey
   String name;

    String topicName;
}

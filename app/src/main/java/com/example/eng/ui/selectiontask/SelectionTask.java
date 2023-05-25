package com.example.eng.ui.selectiontask;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "Tasks")
public class SelectionTask {

    @PrimaryKey
    @NonNull
    String topicName;

    @Override
    public int hashCode() {
        return Objects.hash(topicName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectionTask that = (SelectionTask) o;
        return topicName.equals(that.topicName);
    }

    @NonNull
    @Override
    public String toString() {
        return "SelectionTask{" +
                "topicName='" + topicName + '\'' +
                '}';
    }
}

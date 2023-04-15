package com.example.eng.ui.topicselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TopicSelectionViewModel extends ViewModel implements TopicAdapter.OnItemClickListener {
    private MutableLiveData<ArrayList<Topic>> _topics = new MutableLiveData<ArrayList<Topic>>(getTopicList());
    public LiveData<ArrayList<Topic>> topics = _topics;

    @Override
    public void onItemClick(Topic item) {
    }

    public ArrayList<Topic> getTopicList(){

        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Topic1"));
        topics.add(new Topic("Topic2"));
        topics.add(new Topic("Topic3"));
        topics.add(new Topic("Topic4"));
        topics.add(new Topic("Topic5"));

        return topics;
    }

}

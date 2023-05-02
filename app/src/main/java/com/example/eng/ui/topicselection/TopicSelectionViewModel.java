package com.example.eng.ui.topicselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TopicSelectionViewModel extends ViewModel implements TopicAdapter.OnItemClickListener {
    private TopicDAO topicDAO;
    public MutableLiveData<List<Topic>> _topics=new MutableLiveData<>();
    public LiveData<List<Topic>> topics = _topics;
    @Inject
    public TopicSelectionViewModel(TopicDAO topicDAO){
        this.topicDAO=topicDAO;
        topics=topicDAO.getAll();

        /*
        if(topics.getValue().isEmpty()) {
            this.topicDAO.insertAll(getTopicList());
        }

         */


    }

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

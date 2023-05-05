package com.example.eng.ui.topicselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.data.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TopicSelectionViewModel extends ViewModel implements TopicAdapter.OnItemClickListener {
    private TopicDAO topicDAO;
    public final LiveData<List<Topic>> topics;

    @Inject
    public TopicSelectionViewModel(TopicDAO topicDAO, SharedPreferencesManager sharedPreferencesManager) {
        this.topicDAO = topicDAO;
        topics = this.topicDAO.getAll();

        if (sharedPreferencesManager.checkIsFirstLaunch()) {//если первый запуск
            this.topicDAO.insertAll(getTopicList());//добавляем все
            sharedPreferencesManager.setIsFirstLaunch();//не первый запуск
        }
    }

    @Override
    public void onItemClick(Topic item) {
    }

    public ArrayList<Topic> getTopicList() {
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Topic1"));
        topics.add(new Topic("Topic2"));
        topics.add(new Topic("Topic3"));
        topics.add(new Topic("Topic4"));
        topics.add(new Topic("Topic5"));
        return topics;
    }
}

package com.example.eng.ui.topicselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.eng.util.SingleLiveEvent;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TopicSelectionViewModel extends ViewModel implements TopicAdapter.OnItemClickListener {
    private TopicDAO topicDAO;
    public final LiveData<List<Topic>> topics;

    private SingleLiveEvent<String> _navigationToSelectionTaskFragment = new SingleLiveEvent<>();
    LiveData<String> navigationToSelectionTaskFragment = _navigationToSelectionTaskFragment;

    @Inject
    public TopicSelectionViewModel(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
        topics = this.topicDAO.getAll();
    }

    @Override
    public void onItemClick(Topic item) {
        _navigationToSelectionTaskFragment.setValue(item.getName());
    }
}

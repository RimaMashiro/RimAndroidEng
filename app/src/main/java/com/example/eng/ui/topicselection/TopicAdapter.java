package com.example.eng.ui.topicselection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.eng.R;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{

    private ArrayList<Topic> topics;
    private final OnItemClickListener onItemClickListener;
    public TopicAdapter(OnItemClickListener onItemClickListener ) {
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicAdapter.ViewHolder holder, int position) {
        Topic task = topics.get(position);
        holder.nameView.setText(task.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(task);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public void updateTasksList(final ArrayList<Topic> tasks) {
        this.topics.clear();
        this.topics = tasks;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nameView;
        ViewHolder(View view){
            super(view);

            nameView = view.findViewById(R.id.name);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Topic item);
    }

}
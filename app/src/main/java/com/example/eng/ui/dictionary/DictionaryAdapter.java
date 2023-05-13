package com.example.eng.ui.dictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eng.R;
import com.example.eng.ui.topicselection.Topic;
import com.example.eng.ui.topicselection.TopicAdapter;

import java.util.ArrayList;
import java.util.List;

public class DictionaryAdapter {
    /*

    public class DictionaryAdapter extends RecyclerView.Adapter<com.example.eng.ui.dictionary.DictionaryAdapter>{

        private List<Dictionary> dictionary=new ArrayList<>();
        private final com.example.eng.ui.topicselection.TopicAdapter.OnItemClickListener onItemClickListener;
        public TopicAdapter(com.example.eng.ui.topicselection.TopicAdapter.OnItemClickListener onItemClickListener ) {
            this.onItemClickListener=onItemClickListener;
        }
        @Override
        public com.example.eng.ui.topicselection.TopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new com.example.eng.ui.topicselection.TopicAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(com.example.eng.ui.topicselection.TopicAdapter.ViewHolder holder, int position) {
            Topic topic = topics.get(position);
            holder.nameView.setText(topic.getName());
            holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(topic));
        }

        @Override
        public int getItemCount() {
            return topics.size();
        }

        public void updateTasksList(final List<Topic> topics) {
            this.topics.clear();
            this.topics = topics;
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

     */
}

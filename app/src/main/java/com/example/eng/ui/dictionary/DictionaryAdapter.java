package com.example.eng.ui.dictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eng.R;

import java.util.ArrayList;
import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.ViewHolder> {

    private List<String> wordsRus = new ArrayList<String>();
    private List<String> wordsEng = new ArrayList<String>();

    @Override
    public DictionaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dictionary_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DictionaryAdapter.ViewHolder holder, int position) {
        String wordEngl = wordsEng.get(position);
        String wordRuss = wordsRus.get(position);

        holder.wordRus.setText(wordRuss);
        holder.wordEng.setText(wordEngl);
    }

    public void updateWordsList(final Dictionary dictionary) {
        this.wordsEng.clear();
        this.wordsRus.clear();
        wordsRus = dictionary.getWordsRus();
        wordsEng = dictionary.getWordsEng();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView wordRus;
        final TextView wordEng;

        ViewHolder(View view) {
            super(view);
            wordRus = view.findViewById(R.id.textRussians);
            wordEng = view.findViewById(R.id.textEnglish);
        }
    }

    @Override
    public int getItemCount() {
        return wordsEng.size();
    }
}

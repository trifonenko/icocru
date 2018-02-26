package ru.app.churchofchrist.good_news;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsRecyclerViewAdapter extends RecyclerView.Adapter<GoodNewsRecyclerViewAdapter.ViewHolder> {

    private String[] captions;

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout cardView;
        ViewHolder(ConstraintLayout v) {
            super(v);
            cardView = v;
        }
    }
    public GoodNewsRecyclerViewAdapter(String[] captions){
        this.captions = captions;
    }

    @Override
    public GoodNewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ConstraintLayout cv = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recucler_view_good_news, parent, false);
        return new ViewHolder(cv);
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        ConstraintLayout cardView = holder.cardView;
        TextView textView = cardView.findViewById(R.id.title_good_news);
        textView.setText(captions[position]);
    }
    @Override
    public int getItemCount(){
        return captions.length;
    }
}

package ru.app.churchofchrist.songs;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Адаптер для RecyclerView.
 */

public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.ViewHolder> {

    private String[] captions;
    private Listener listener;
    public static interface Listener {
        public void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public SongsListAdapter(String[] captions){
        this.captions = captions;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public SongsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_songs_list, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        TextView textView = cardView.findViewById(R.id.song_name_list);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }
}

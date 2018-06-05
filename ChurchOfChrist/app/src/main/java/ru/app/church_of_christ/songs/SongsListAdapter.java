package ru.app.church_of_christ.songs;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.app.church_of_christ.R;

/**
 * Адаптер для RecyclerView.
 */

public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.ViewHolder> {

    private List<Song> mSongs;
    private Listener listener;

    public interface Listener {
        void onClick(int songId);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    SongsListAdapter(List<Song> songs) {
        this.mSongs = songs;
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SongsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_songs, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;

        TextView text = cardView.findViewById(R.id.song_name);
        text.setText(mSongs.get(position).getName());

        TextView id = cardView.findViewById(R.id.song_id);
        id.setText(String.valueOf(mSongs.get(position).getId()));

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(mSongs.get(position).getId() - 1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}

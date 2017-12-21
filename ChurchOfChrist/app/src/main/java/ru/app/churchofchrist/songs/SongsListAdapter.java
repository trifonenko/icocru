package ru.app.churchofchrist.songs;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.app.churchofchrist.R;

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

    void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public SongsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_songs_list, parent, false);
        return new ViewHolder(cv);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;
        final TextView text = cardView.findViewById(R.id.song_name_list);
        final TextView id = cardView.findViewById(R.id.song_id);
        id.setText("" + mSongs.get(position).getId());
        text.setText(mSongs.get(position).getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence songName = text.getText();
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

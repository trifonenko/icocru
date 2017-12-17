package ru.app.churchofchrist.songs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Список песен.
 */
public class SongsListFragment extends Fragment {

    interface SongListListener {
        void onItemClicked(long id);
    }

    private SongListListener listener;
    private RecyclerView mSongsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_songs_list, container, false);

        SongsLab songsLab = SongsLab.getInstance(getActivity());
        List<Song> songs = songsLab.getSongs();
        String[] pizzaNames = new String[songs.size()];

        for (int i = 0; i < songs.size(); i++) {
            pizzaNames[i] = songs.get(i).getName();
        }

        SongsListAdapter adapter = new SongsListAdapter(pizzaNames);
        pizzaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new SongsListAdapter.Listener() {
            public void onClick(int position) {
                if (listener != null) {
                    listener.onItemClicked(position);
                }
            }
        });
        return pizzaRecycler;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SongListListener) context;
    }
}

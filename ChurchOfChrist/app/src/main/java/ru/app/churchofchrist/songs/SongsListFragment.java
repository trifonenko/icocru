package ru.app.churchofchrist.songs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Список песен.
 */
public class SongsListFragment extends Fragment {

    interface SongListListener {
        void onItemClicked(CharSequence songName);
    }

    private SongListListener listener;
    private RecyclerView mSongsRecyclerView;
    private List<Song> songs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        mSongsRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_songs_list, container, false);

        SongsLab songsLab = SongsLab.getInstance(getActivity());
        songs = songsLab.getSongs();
        String[] names = new String[songs.size()];

        for (int i = 0; i < songs.size(); i++) {
            names[i] = songs.get(i).getName();
        }

        SongsListAdapter adapter = new SongsListAdapter(names);
        mSongsRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mSongsRecyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new SongsListAdapter.Listener() {
            public void onClick(CharSequence songName) {
                if (listener != null) {
                    listener.onItemClicked(songName);
                }
            }
        });
        return mSongsRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SongListListener) context;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_songs, menu);
        MenuItem searchItem = menu.findItem(R.id.search_songs);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mSongsRecyclerView.getAdapter().notifyDataSetChanged();
                ArrayList<String> songsListArray = new ArrayList<>();

                for (Song item : songs) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        songsListArray.add(item.getName());
                    }
                }
                String[] names = new String[songsListArray.size()];
                for (int i = 0; i < songsListArray.size(); i++) {
                    names[i] = songsListArray.get(i);
                }

                SongsListAdapter adapter = new SongsListAdapter(names);
                mSongsRecyclerView.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                mSongsRecyclerView.setLayoutManager(layoutManager);
                adapter.setListener(new SongsListAdapter.Listener() {
                    public void onClick(CharSequence songName) {
                        if (listener != null) {
                            listener.onItemClicked(songName);
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_songs:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

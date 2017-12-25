package ru.app.churchofchrist.songs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.app.churchofchrist.R;

/**
 * Список песен.
 */
public class SongsListFragment extends Fragment {

    interface SongListListener {
        void onItemClicked(int songId);
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
        onRunSong(songs);
        return mSongsRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SongListListener) context;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Song> songsFilter = new ArrayList<>();
                for (Song song : songs) {
                    if (searchSongs(song, newText)) {
                        songsFilter.add(song);
                    }
                }
                onRunSong(songsFilter);
                return true;
            }
        });
    }

    private void onRunSong(List<Song> songs) {
        SongsListAdapter adapter = new SongsListAdapter(songs);
        mSongsRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mSongsRecyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new SongsListAdapter.Listener() {
            public void onClick(int songId) {
                if (listener != null) {
                    listener.onItemClicked(songId);
                }
            }
        });
    }

    //Поиск песен по списку имен.
    private boolean searchSongs(Song song, String newText) {
        String regex = "\\s|,|!|\\(|\\)|\\.|-|_";//Регулярное выражение.
        String songName = song.getName();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNewText = pattern.matcher(newText);
        newText = (matcherNewText.replaceAll("")).toLowerCase();
        Matcher matcherSongName = pattern.matcher(songName);
        songName = (matcherSongName.replaceAll("")).toLowerCase();
        return songName.contains(newText);
    }
}

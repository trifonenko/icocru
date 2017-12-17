package ru.app.churchofchrist.songs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Фрагмент показвает аккорды песни.
 */
public class SongsChordFragment extends Fragment {
    private String songName;
    private static final String KEY = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            songName = savedInstanceState.getString(KEY);
        }
        return inflater.inflate(R.layout.fragment_chords_song, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView textSong = view.findViewById(R.id.text_chords);

        SongsLab songsLab = SongsLab.getInstance(getActivity());
        List<Song> songs = songsLab.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            if (songName.equals(songs.get(i).getName())) {
                //textSong.setText(songs.get(i).getChordsResId());
                break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY, songName);
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

}

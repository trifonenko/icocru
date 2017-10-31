package ru.app.churchofchrist.christiansongs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Фрагмент показывает текст песни.
 */
public class TextSongFragment extends Fragment {
    private String songName;
    private static final String KEY = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            songName = savedInstanceState.getString(KEY);
        }
        return inflater.inflate(R.layout.fragment_text_song, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY, songName);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView textSong = (TextView) view.findViewById(R.id.text_song1);

        for (int i = 0; i < Song.getArraySongs().length; i++) {
            if (songName.equals(Song.getArraySongs()[i].getName())) {
                textSong.setText(Song.getArraySongs()[i].getText());
                break;
            }
        }
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

package ru.app.churchofchrist.songs;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Фрагмент, для отображения текста песен.
 */
public class SongsTextFragment extends Fragment {

    private long songId;//Идентификатор песни, выбранной пользователем.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            songId = savedInstanceState.getLong("songId");
        }
        return inflater.inflate(R.layout.fragment_songs_text, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Song song = Song.getArraySongs()[(int) songId];
            TextView songName = view.findViewById(R.id.song_name);
            songName.setText(song.getName());
            TextView songText = view.findViewById(R.id.song_text);
            songText.setText(song.getText());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("songId", songId);
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }
}

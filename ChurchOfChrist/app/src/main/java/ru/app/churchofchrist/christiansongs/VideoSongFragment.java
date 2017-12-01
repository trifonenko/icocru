package ru.app.churchofchrist.christiansongs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Фрагмент показвает видео песни.
 */
public class VideoSongFragment extends Fragment /*implements View.OnClickListener*/ {
    private String songName;
    private static final String KEY = "key";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            songName = savedInstanceState.getString(KEY);
        }
        return inflater.inflate(R.layout.fragment_video_song, container, false);

    }

    /*@Override
    public void onStart() {
        super.onStart();
        View view = getView();
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.button:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                    startActivity(intent);
                    break;
            }
        }*/

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView textVideo = view.findViewById(R.id.text_video);

        for (int i = 0; i < Song.getArraySongs().length; i++) {
            if (songName.equals(Song.getArraySongs()[i].getName())) {
                textVideo.setText(Song.getArraySongs()[i].getLinkVideo());
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

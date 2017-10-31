package ru.app.churchofchrist.christiansongs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.app.churchofchrist.R;

/**
 * Фрагмент используется в TabLayout, показывает все треки этой песни.
 */
public class AudioSongFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audio_song, container, false);
    }

}

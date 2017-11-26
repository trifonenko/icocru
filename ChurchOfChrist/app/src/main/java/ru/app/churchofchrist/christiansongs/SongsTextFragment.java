package ru.app.churchofchrist.christiansongs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.app.churchofchrist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsTextFragment extends Fragment {


    public SongsTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs_text, container, false);
    }

}

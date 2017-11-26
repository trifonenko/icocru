package ru.app.churchofchrist.songs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.app.churchofchrist.R;

public class SongTextActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_text);
        SongsTextFragment workoutDetailFragment = (SongsTextFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        workoutDetailFragment.setSongId(workoutId);
    }
}

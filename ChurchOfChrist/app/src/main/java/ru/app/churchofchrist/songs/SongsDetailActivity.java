package ru.app.churchofchrist.songs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import ru.app.churchofchrist.R;

public class SongsDetailActivity extends AppCompatActivity {

    public static final String SONG_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (savedInstanceState == null) {
            SongsDetailFragment songsDetailFragment = (SongsDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_songs_detail);
            int songId = (int) getIntent().getExtras().get(SONG_ID);
            songsDetailFragment.setSongId(songId);
        }
    }
}

package ru.app.church_of_christ.songs;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ru.app.church_of_christ.R;

public class SongsActivity extends AppCompatActivity implements SongsListFragment.SongListListener {

    private View fragmentContainer;
    public static boolean sSongId = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            sSongId = true;
            if (savedInstanceState == null) {
                onItemClicked(0);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SongsFavoritesActivity.i) {
            Intent intent = getIntent();
            int ii = intent.getIntExtra(SongsDetailActivity.SONG_ID, 1);
            onItemClicked(ii);
        }
    }

    @Override
    public void onItemClicked(int songId) {
        if (fragmentContainer != null) {
            SongsDetailFragment songsDetailFragment = new SongsDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            songsDetailFragment.setSongId(songId);
            ft.replace(R.id.fragment_container, songsDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, SongsDetailActivity.class);
            intent.putExtra(SongsDetailActivity.SONG_ID, songId);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_songs_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites_songs:
                Intent intent = new Intent(this, SongsFavoritesActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

package ru.app.churchofchrist.songs;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ru.app.churchofchrist.R;

public class SongsActivity extends AppCompatActivity implements SongsListFragment.SongListListener {

    public static final String fav = "fav";
    public static boolean f = false;

    private View fragmentContainer;

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
            if (savedInstanceState == null) {
                onItemClicked(1);
            }
        }

        Intent intent = getIntent();
        if (fragmentContainer != null) {
            if (intent != null) {
                int w = intent.getIntExtra(fav, 1);
                onItemClicked(w);
            }
        }
    }

    @Override
    public void onItemClicked(int songId) {
        if (fragmentContainer != null) {
            f = true;
            SongsDetailFragment songsDetailFragment = new SongsDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            songsDetailFragment.setSongId(songId);
            ft.replace(R.id.fragment_container, songsDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, SongsDetailActivity.class);
            intent.putExtra(SongsDetailActivity.EXTRA_WORKOUT_ID, songId);
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
        switch (item.getItemId()){
            case R.id.favorites_songs:
                Intent intent = new Intent(this, SongsFavoritesActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

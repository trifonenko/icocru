package ru.app.churchofchrist.songs;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.app.churchofchrist.R;

public class SongsActivity extends AppCompatActivity implements SongsListFragment.SongListListener {

    private View fragmentContainer;
    private List<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        SongsLab mSongsLab = SongsLab.getInstance(this);
        mSongs = mSongsLab.getSongs();

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
                onItemClicked(0);
            }
        }
    }

    @Override
    public void onItemClicked(long id) {
        if (fragmentContainer != null) {
            SongsDetailFragment songsDetailFragment = new SongsDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            songsDetailFragment.setSongId(id);
            ft.replace(R.id.fragment_container, songsDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, SongsDetailActivity.class);
            intent.putExtra(SongsDetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_songs, menu);
        MenuItem searchItem = menu.findItem(R.id.search_songs);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> songsListArray = new ArrayList<>();

                for (Song item : mSongs) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        songsListArray.add(item.getName());
                    }
                }
                //listSongs = findViewById(R.id.list_songs);
                //ArrayAdapter<String> adapterListSongs = new ArrayAdapter<>(ChristianSongsActivity.this, R.layout.christiansong_item_list, songsListArray);
                //listSongs.setAdapter(adapterListSongs);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.random_song:
                Random random = new Random();
                int randomNumber = random.nextInt(mSongs.size());
                //runSong(Song.getArraySongs()[randomNumber].getName());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package ru.app.churchofchrist.songs;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import ru.app.churchofchrist.R;

public class SongsFavoritesActivity extends AppCompatActivity {

    public static boolean i = false;
    private RecyclerView recyclerView;
    private List<Song> songsFav;
    private SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_favorites);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SongsLab lab = SongsLab.getInstance(this);
        songsFav = lab.getFavoritesSongs();
        DBHelperSongs helperSongs = new DBHelperSongs(this, "db_songs", 1);
        sqLiteDatabase = helperSongs.getWritableDatabase();

        recyclerView = findViewById(R.id.recycler_songs_fav);
        SongsListAdapter adapter = new SongsListAdapter(songsFav);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new SongsListAdapter.Listener() {
            @Override
            public void onClick(int songId) {
                if (SongsActivity.sSongId) {
                    i = true;
                    Intent intent = new Intent(SongsFavoritesActivity.this, SongsActivity.class);
                    intent.putExtra(SongsDetailActivity.SONG_ID, songId);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SongsFavoritesActivity.this, SongsDetailActivity.class);
                    intent.putExtra(SongsDetailActivity.SONG_ID, songId);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_songs_favorites_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                for (int i = 0; i < songsFav.size(); i++) {
                    sqLiteDatabase.delete("FAV_SONGS", "ID = ?", new String[]{String.valueOf(songsFav.get(i).getId())});
                }
                songsFav.clear();
                sqLiteDatabase.close();
                SongsListAdapter adapter = new SongsListAdapter(songsFav);
                recyclerView.setAdapter(adapter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

package ru.app.churchofchrist.songs;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
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

import ru.app.churchofchrist.DBHelper;
import ru.app.churchofchrist.R;

public class SongsFavoritesActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    public static boolean i = false;
    private SongsLab lab;
    private RecyclerView recyclerView;
    List<Song> songsFav;

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

        recyclerView = findViewById(R.id.recycler_songs_fav);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        lab = SongsLab.getInstance(this);
    }

    @SuppressLint("ShowToast")
    @Override
    public void onStart() {
        super.onStart();
        songsFav = lab.getFavoritesSongs();
        SongsListAdapter adapter = new SongsListAdapter(songsFav);

        recyclerView.setAdapter(adapter);
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

    @SuppressLint("ShowToast")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all:
                if (SongsLab.getInstance(this).getFavoritesSongs().size() != 0) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(R.string.delete_songs)
                            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    DBHelper helperSongs = new DBHelper(getApplicationContext(), "db_songs", 1);
                                    SQLiteDatabase database = helperSongs.getWritableDatabase();

                                    for (int i = 0; i < songsFav.size(); i++) {
                                        database.delete("FAV_SONGS", "ID = ?", new String[]{String.valueOf(songsFav.get(i).getId())});
                                    }
                                    songsFav.clear();
                                    SongsListAdapter adapter = new SongsListAdapter(songsFav);
                                    recyclerView.setAdapter(adapter);

                                    database.close();
                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    builder.show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

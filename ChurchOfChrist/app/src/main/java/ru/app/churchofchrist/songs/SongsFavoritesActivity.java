package ru.app.churchofchrist.songs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import ru.app.churchofchrist.R;

public class SongsFavoritesActivity extends AppCompatActivity {

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
        List<Song> songsFav = lab.getFavoritesSongs();

        RecyclerView recyclerView = findViewById(R.id.recycler_songs_fav);
        SongsListAdapter adapter = new SongsListAdapter(songsFav);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new SongsListAdapter.Listener() {
            @Override
            public void onClick(int songId) {
                if (SongsActivity.f) {
                    Intent intent = new Intent(SongsFavoritesActivity.this, SongsActivity.class);
                    intent.putExtra(SongsActivity.fav, songId);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SongsFavoritesActivity.this, SongsDetailActivity.class);
                    intent.putExtra(SongsDetailActivity.EXTRA_WORKOUT_ID, songId);
                    startActivity(intent);
                }
                }
            });
        }
    }

package ru.app.churchofchrist.songs;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ru.app.churchofchrist.R;

public class SongsActivity extends AppCompatActivity implements SongsListFragment.SongListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onItemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
        SongsTextFragment songsTextFragment = new SongsTextFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        songsTextFragment.setSongId(id);
        ft.replace(R.id.fragment_container, songsTextFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        } else {
            Intent intent = new Intent(this, SongTextActivity.class);
            intent.putExtra(SongTextActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}

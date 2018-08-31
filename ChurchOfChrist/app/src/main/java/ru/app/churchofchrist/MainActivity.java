package ru.app.churchofchrist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.app.churchofchrist.bible.BibleStartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frame_container);
        if (fragment == null) {
            Fragment mainFragment = new BottomNavigationMainFragment();
            manager.beginTransaction().add(R.id.frame_container, mainFragment).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Fragment mainFragment = new BottomNavigationMainFragment();
                        manager.beginTransaction().replace(R.id.frame_container, mainFragment).commit();
                        break;
                    case R.id.bible:
                        Fragment bibleFragment = new BibleStartFragment();
                        manager.beginTransaction().replace(R.id.frame_container, bibleFragment).commit();
                        break;
                    case R.id.further:
                        Fragment furtherFragment = new BottomNavigationFurtherFragment();
                        manager.beginTransaction().replace(R.id.frame_container, furtherFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}
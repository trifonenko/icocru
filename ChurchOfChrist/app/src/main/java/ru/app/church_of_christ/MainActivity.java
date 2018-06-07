package ru.app.church_of_christ;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.app.church_of_christ.bible.BibleStartFragment;
import ru.app.church_of_christ.christian_foundation.BasicChristianFragment;
import ru.app.church_of_christ.songs.SongsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorPrimaryDark));
        } else {
            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

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
                    case R.id.basic:
                        Fragment basicChristianFragment = new BasicChristianFragment();
                        manager.beginTransaction().replace(R.id.frame_container, basicChristianFragment).commit();
                        break;
                    case R.id.songs:
                        Intent intent = new Intent(MainActivity.this, SongsActivity.class);
                        startActivity(intent);
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
package ru.app.churchofchrist.main;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ru.app.churchofchrist.AppInfoActivity;
import ru.app.churchofchrist.FeedbackActivity;
import ru.app.churchofchrist.HomeFragment;
import ru.app.churchofchrist.R;
import ru.app.churchofchrist.bible.BibleActivityStart;
import ru.app.churchofchrist.foundations_of_christianity.LessonsFragment;
import ru.app.churchofchrist.songs.SongsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new HomeFragment();
        fragmentManager.beginTransaction()
                       .add(R.id.id_fragment_container, fragment, "home_fragment_tag")
                       .commit();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.main:
                    Fragment homeFragment = fragmentManager.findFragmentByTag("home_fragment_tag");
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                    }
                        fragmentManager.beginTransaction()
                                       .replace(R.id.id_fragment_container, homeFragment, "home_fragment_tag")
                                       .commit();
                    break;
                case R.id.foundations_of_christianity:
                    Fragment lessonsFragment = fragmentManager.findFragmentByTag("lessons_fragment_tag");
                    if (lessonsFragment == null) {
                        lessonsFragment = new LessonsFragment();
                    }
                    fragmentManager.beginTransaction()
                                   .replace(R.id.id_fragment_container, lessonsFragment, "lessons_fragment_tag")
                                   .commit();
                    break;
                case R.id.songs:
                    Intent intent2 = new Intent(MainActivity.this, SongsActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.notepad:
                    Intent intent3 = new Intent(MainActivity.this, ru.app.churchofchrist.notepad.MainActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.bible:
                    Intent intent4 = new Intent(MainActivity.this, BibleActivityStart.class);
                    startActivity(intent4);
                    break;
                case R.id.ansver:
                    Intent intent5 = new Intent(MainActivity.this, ru.app.churchofchrist.ansver.AnsverActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.feedback:
                    Intent intent6 = new Intent(MainActivity.this, FeedbackActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.app_info:
                    Intent intent7 = new Intent(MainActivity.this, AppInfoActivity.class);
                    startActivity(intent7);
                    break;
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
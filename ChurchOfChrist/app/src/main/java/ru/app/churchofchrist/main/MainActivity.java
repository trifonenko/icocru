package ru.app.churchofchrist.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import ru.app.churchofchrist.AppInfoActivity;
import ru.app.churchofchrist.FeedbackActivity;
import ru.app.churchofchrist.R;
import ru.app.churchofchrist.bible.BibleActivityStart;
import ru.app.churchofchrist.ox.OxActivity;
import ru.app.churchofchrist.songs.SongsActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.CollapsingToolbarLayout);
        AppBarLayout appBarLayout = findViewById(R.id.id_app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Церковь Христа");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    isShow = false;
                }
            }
        });
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.basic_christ:
                Intent intent1 = new Intent(MainActivity.this, OxActivity.class);
                startActivity(intent1);
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
package ru.app.churchofchrist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

import ru.app.churchofchrist.bible.BibleActivityStart;
import ru.app.churchofchrist.good_news.GoodNewsActivity;
import ru.app.churchofchrist.ox.OxActivity;
import ru.app.churchofchrist.plans.PlansActivity;
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




        DBHelper dbHelper = new DBHelper(this, "lessons.db", 2);//07.02.2018 (версия в google 2)
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        final SQLiteDatabase database = dbHelper.getReadableDatabase();
        this.randomVerse(database);

        ImageView random = findViewById(R.id.imageView9);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomVerse(database);
            }
        });

        ImageView share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                TextView verse = findViewById(R.id.random_verse);
                TextView coordinatesVerse = findViewById(R.id.coordinates_verse);
                String textToSend = verse.getText()+ "\n\n" + coordinatesVerse.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                try {
                    startActivity(Intent.createChooser(intent, "Описание действия"));
                }
                catch (android.content.ActivityNotFoundException ignored) {
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
            case R.id.good_news:
                Intent intentGoodNews = new Intent(MainActivity.this, GoodNewsActivity.class);
                startActivity(intentGoodNews);
                break;
            case R.id.plans:
                Intent intentPlans = new Intent(MainActivity.this, PlansActivity.class);
                startActivity(intentPlans);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Случайный отрывок.
    private void randomVerse(SQLiteDatabase database) {
        Cursor cursor = database.rawQuery("SELECT * FROM bible_verse_s", null);
        Random random = new Random();
        int randomNum = random.nextInt(cursor.getCount());
        cursor.moveToPosition(randomNum);

        TextView verse = findViewById(R.id.random_verse);
        verse.setText(cursor.getString(0));
        TextView coordinatesVerse = findViewById(R.id.coordinates_verse);
        coordinatesVerse.setText(cursor.getString(1));

        cursor.close();
    }
}
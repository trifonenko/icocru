package ru.app.churchofchrist.bible;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import ru.app.churchofchrist.R;

public class BibleActivityStart extends AppCompatActivity {
private TextView textViewKnig;
private TextView textViewStih;
    static final String BLOG_URL = "https://okbible.ru/rndvers.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewKnig = (TextView) findViewById(R.id.textViewKnig);
        textViewStih = (TextView) findViewById(R.id.textViewStih);
    }

    public void click_sinod(View view)
    {
        Intent intent = new Intent(BibleActivityStart.this, BibleActivity2.class);
        startActivity(intent);
    }

    public void click_sovr(View view)
    {
        Intent intent2 = new Intent(BibleActivityStart.this, BibleActivity.class);
        startActivity(intent2);
    }



}

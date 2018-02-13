package ru.app.churchofchrist.bible;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import ru.app.churchofchrist.R;

public class BibleActivityStart extends AppCompatActivity {
    private WebView webView_otr;
    private WebView webView_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

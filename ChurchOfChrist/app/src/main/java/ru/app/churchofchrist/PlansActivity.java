package ru.app.churchofchrist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;

public class PlansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        setTitle("Планы Церкви");

        TabHost tabHost = findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("Юг");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.linearLayout2);
        tabSpec.setIndicator("Запад");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.linearLayout3);
        tabSpec.setIndicator("Восток");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*CollapsingToolbarLayout c = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        c.setExpandedTitleColor(ContextCompat.getColor(this, R.color.colorStatusBar));*/

        WebView webViewV = findViewById(R.id.webViewPlansVostok);
        WebView webViewZ = findViewById(R.id.webViewPlansZapad);
        WebView webViewU = findViewById(R.id.webViewPlansUg);

        WebSettings webSettingsV = webViewV.getSettings();
        WebSettings webSettingsZ = webViewZ.getSettings();
        WebSettings webSettingsU = webViewU.getSettings();
        webSettingsV.setJavaScriptEnabled(true);
        webSettingsZ.setJavaScriptEnabled(true);
        webSettingsU.setJavaScriptEnabled(true);

        webViewV.loadUrl("https://calendar.google.com/calendar/embed?src=macsq3nc3pc72hos0mee75ahgk%40group.calendar.google.com&ctz=Asia/Krasnoyarsk");
        webViewV.setWebViewClient(new MyWebViewClient());
        webViewZ.loadUrl("https://calendar.google.com/calendar/embed?src=1n62pcdf7ijt65qq8t08redbis%40group.calendar.google.com&ctz=Asia/Krasnoyarsk");
        webViewZ.setWebViewClient(new MyWebViewClient());
        webViewU.loadUrl("https://calendar.google.com/calendar/embed?src=7vgnun09djjh4snbc67h74igkc%40group.calendar.google.com&ctz=Asia/Krasnoyarsk");
        webViewU.setWebViewClient(new MyWebViewClient());
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

package ru.app.churchofchrist.bible;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import ru.app.churchofchrist.R;
import ru.app.churchofchrist.songs.SongsListFragment;


public class BibleActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "spinner_value";
    int id=0;

    private WebView webView;
    Menu myMenu = null;
    private ProgressDialog mProgressDialog;
    Handler handler;
    SharedPreferences sPref; // Сохранение
    int knig; // Размер текста
    private boolean isInternetPresent;
    private SongsListFragment.ConnectionDetector cd;
    private Toolbar toolbar=null;
    private String[] category=null;
    String[] knigi = {"Бытие", "Исход", "Левит", "Числа", "Второзаконие", "Иисус Навин", "Судьи", "Руфь", "1 Царств", "2 Царств", "3 Царств", "4 Царств", "1 Паралипоменон", "2 Паралипоменон", "Ездра", "Неемии", "Есфирь", "Иов", "Псалтирь", "Притчи", "Екклесиаст", "Песня Песней", "Исаия", "Иеремия", "Плач Иеремии", "Иезекииль", "Даниил", "Осия", "Иоиль", "Амос", "Авдий", "Иона", "Михей", "Наум", "Аввакум", "Софония", "Аггей", "Захария", "Малахия", "Матфей", "Марк", "Лука", "Иоанн", "Деяния", "Иаков", "1 Петра", "2 Петра", "1 Иоанна", "2 Иоанна", "3 Иоанна", "Иуда", "Римлянам", "1 Коринфянам", "2 Коринфянам", "Галатам", "Ефесянам", "Филиппийцам", "Колоссянам", "1 Фессалоникийцам", "2 Фессалоникийцам", "1 Тимофею", "2 Тимофею", "Титу", "Филимону", "Евреям", "Откровение"};
    private ProgressDialog progressDialog;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible);
        category = getResources().getStringArray(R.array.perevod);

        //Логическая переменная для статуса соединения
        Boolean isInternetPresent = false;
        SongsListFragment.ConnectionDetector cd;

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, knigi);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);

        Spinner spinner2 = findViewById(R.id.knigi);
        spinner2.setAdapter(adapter2);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val",0);
        spinner2.setSelection(id);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("last_val", position);
                editor.commit();

                switch (position) {
                    case 0:
                        webView.loadUrl("file:///android_asset/books/01_genesis.html");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/books/02_exodus.html");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/books/03_leviticus.html");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/books/04_numbers.html");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/books/05_deuteronomy.html");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/books/06_joshua.html");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/books/07_judges.html");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/books/08_ruth.html");
                        break;
                    case 8:
                        webView.loadUrl("file:///android_asset/books/09_1samuel.html");
                        break;
                    case 9:
                        webView.loadUrl("file:///android_asset/books/10_2samuel.html");
                        break;
                    case 10:
                        webView.loadUrl("file:///android_asset/books/11_1kings.html");
                        break;
                    case 11:
                        webView.loadUrl("file:///android_asset/books/12_2kings.html");
                        break;
                    case 12:
                        webView.loadUrl("file:///android_asset/books/13_1chronicles.html");
                        break;
                    case 13:
                        webView.loadUrl("file:///android_asset/books/14_2chronicles.html");
                        break;
                    case 14:
                        webView.loadUrl("file:///android_asset/books/15_ezra.html");
                        break;
                    case 15:
                        webView.loadUrl("file:///android_asset/books/16_nehemiah.html");
                        break;
                    case 16:
                        webView.loadUrl("file:///android_asset/books/17_esther.html");
                        break;
                    case 17:
                        webView.loadUrl("file:///android_asset/books/18_job.html");
                        break;
                    case 18:
                        webView.loadUrl("file:///android_asset/books/19_psalms.html");
                        break;
                    case 19:
                        webView.loadUrl("file:///android_asset/books/20_proverbs.html");
                        break;
                    case 20:
                        webView.loadUrl("file:///android_asset/books/21_ecclesiastes.html");
                        break;
                    case 21:
                        webView.loadUrl("file:///android_asset/books/22_songofsolomon.html");
                        break;
                    case 22:
                        webView.loadUrl("file:///android_asset/books/23_isaiah.html");
                        break;
                    case 23:
                        webView.loadUrl("file:///android_asset/books/24_jeremiah.html");
                        break;
                    case 24:
                        webView.loadUrl("file:///android_asset/books/25_lamentations.html");
                        break;
                    case 25:
                        webView.loadUrl("file:///android_asset/books/26_ezekiel.html");
                        break;
                    case 26:
                        webView.loadUrl("file:///android_asset/books/27_daniel.html");
                        break;
                    case 27:
                        webView.loadUrl("file:///android_asset/books/28_hosea.html");
                        break;
                    case 28:
                        webView.loadUrl("file:///android_asset/books/29_joel.html");
                        break;
                    case 29:
                        webView.loadUrl("file:///android_asset/books/30_amos.html");
                        break;
                    case 30:
                        webView.loadUrl("file:///android_asset/books/31_obadiah.html");
                        break;
                    case 31:
                        webView.loadUrl("file:///android_asset/books/32_jonah.html");
                        break;
                    case 32:
                        webView.loadUrl("file:///android_asset/books/33_micah.html");
                        break;
                    case 33:
                        webView.loadUrl("file:///android_asset/books/34_nahum.html");
                        break;
                    case 34:
                        webView.loadUrl("file:///android_asset/books/35_habakkuk.html");
                        break;
                    case 35:
                        webView.loadUrl("file:///android_asset/books/36_zephaniah.html");
                        break;
                    case 36:
                        webView.loadUrl("file:///android_asset/books/37_haggai.html");
                        break;
                    case 37:
                        webView.loadUrl("file:///android_asset/books/38_zechariah.html");
                        break;
                    case 38:
                        webView.loadUrl("file:///android_asset/books/39_malachi.html");
                        break;
                    case 39:
                        webView.loadUrl("file:///android_asset/books/40_matthew.html");
                        break;
                    case 40:
                        webView.loadUrl("file:///android_asset/books/41_mark.html");
                        break;
                    case 41:
                        webView.loadUrl("file:///android_asset/books/42_luke.html");
                        break;
                    case 42:
                        webView.loadUrl("file:///android_asset/books/43_john.html");
                        break;
                    case 43:
                        webView.loadUrl("file:///android_asset/books/44_acts.html");
                        break;
                    case 44:
                        webView.loadUrl("file:///android_asset/books/45_james.html");
                        break;
                    case 45:
                        webView.loadUrl("file:///android_asset/books/46_1peter.html");
                        break;
                    case 46:
                        webView.loadUrl("file:///android_asset/books/47_2peter.html");
                        break;
                    case 47:
                        webView.loadUrl("file:///android_asset/books/48_1john.html");
                        break;
                    case 48:
                        webView.loadUrl("file:///android_asset/books/49_2john.html");
                        break;
                    case 49:
                        webView.loadUrl("file:///android_asset/books/50_3john.html");
                        break;
                    case 50:
                        webView.loadUrl("file:///android_asset/books/51_jude.html");
                        break;
                    case 51:
                        webView.loadUrl("file:///android_asset/books/52_romans.html");
                        break;
                    case 52:
                        webView.loadUrl("file:///android_asset/books/53_1corinthians.html");
                        break;
                    case 53:
                        webView.loadUrl("file:///android_asset/books/54_2corinthians.html");
                        break;
                    case 54:
                        webView.loadUrl("file:///android_asset/books/55_galatians.html");
                        break;
                    case 55:
                        webView.loadUrl("file:///android_asset/books/56_ephesians.html");
                        break;
                    case 56:
                        webView.loadUrl("file:///android_asset/books/57_philippians.html");
                        break;
                    case 57:
                        webView.loadUrl("file:///android_asset/books/58_colossians.html");
                        break;
                    case 58:
                        webView.loadUrl("file:///android_asset/books/59_1thessalonians.html");
                        break;
                    case 59:
                        webView.loadUrl("file:///android_asset/books/60_2thessalonians.html");
                        break;
                    case 60:
                        webView.loadUrl("file:///android_asset/books/61_1timothy.html");
                        break;
                    case 61:
                        webView.loadUrl("file:///android_asset/books/62_2timothy.html");
                        break;
                    case 62:
                        webView.loadUrl("file:///android_asset/books/63_titus.html");
                        break;
                    case 63:
                        webView.loadUrl("file:///android_asset/books/64_philemon.html");
                        break;
                    case 64:
                        webView.loadUrl("file:///android_asset/books/65_hebrews.html");
                        break;
                    case 65:
                        webView.loadUrl("file:///android_asset/books/66_revelations.html");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        webView = findViewById(R.id.webViewBible);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        progressDialog = new ProgressDialog(BibleActivity.this);
        progressDialog.setMessage("Загрузка...");
        progressDialog.show();
            webView.setWebViewClient(new MyWebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(BibleActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    }
    public void onPageFinished(WebView view, String url) {
        if ((mProgressDialog != null) && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    // Пишем код обработки нажатия кнопки назад на устройстве, что позволит нам при нажатии
    // на кнопку "Назад" перейти к предыдущей странице, а не просто закрывать приложения.
    // Оно будет закрываться кнопкой "Назад" лишь в том случае, если мы находимся на стартовой
    // странице, которую указали выше:
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        onBackPressed();
                    } else {
                        onBackPressed();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //Открывать ссылки только на этом сайте
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().length() == 0) {
                return false;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }

        //При невозможности открыть какую либо страницу, открывает html файл с уведомлением
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            view.stopLoading();
            view.loadUrl("file:///android_asset/error.html");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bible, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.zamet_bible:
                Intent intent2 = new Intent(BibleActivity.this, ru.app.churchofchrist.notepad.MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.search_bible:
                webView.loadUrl("https://okbible.ru/extsearch.php");
                break;
            case R.id.random_bible:
                webView.loadUrl("https://okbible.ru/rndvers.php");
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            onNavigateUp();
        }
    }
}
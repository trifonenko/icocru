package ru.app.church_of_christ.plans;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ru.app.church_of_christ.R;
import ru.app.church_of_christ.songs.SongsListFragment;


public class PlansActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "spinner_plans";
    int id=0;

    private WebView webView;
    Menu myMenu = null;
    private Toolbar toolbar = null;
    private String[] category = null;
    String[] city = {"Новосибирск ЮГ", "Новосибирск ЗАПАД", "Новосибирск ВОСТОК"};
    private ProgressDialog progressDialog;
    private TextView text;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        category = getResources().getStringArray(R.array.perevod);

        //Логическая переменная для статуса соединения
        Boolean isInternetPresent = false;
        SongsListFragment.ConnectionDetector cd;
        text = (TextView) findViewById(R.id.text);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item_plans, city);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item_plans);

        Spinner spinner2 = findViewById(R.id.city);
        spinner2.setAdapter(adapter2);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val_plans",0);
        spinner2.setSelection(id);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("last_val_plans", position);
                editor.commit();

                switch (position) {
                    case 0:
                        webView.loadUrl("file:///android_asset/plans/nsk_yug.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("НСК Юг");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/plans/nsk_zp.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("НСК Запад");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/plans/nsk_vost.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("НСК Восток");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        webView = findViewById(R.id.webViewPlans);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        progressDialog = new ProgressDialog(PlansActivity.this);
        progressDialog.setMessage("Загрузка...");
        progressDialog.show();
        webView.setWebViewClient(new MyWebViewClient() {
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
                Toast.makeText(PlansActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();
            }
        });
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);


    }

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
        if (Uri.parse(url).getHost().length() == 0) {
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
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            onNavigateUp();
        }
    }
}

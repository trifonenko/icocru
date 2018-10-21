package ru.app.churchofchrist.foundations_of_christianity;

import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.app.churchofchrist.R;

public class ExcerptDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_dialog);

        this.setFinishOnTouchOutside(false);

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);
        TextView textView = findViewById(R.id.text);

        Uri uri = getIntent().getData();

//        if (uri != null) {
//            String coordinatesExcerpt = uri.getQueryParameter("coordinatesExcerpt");
//            String textExcerpt = uri.getQueryParameter("textExcerpt");
//            Objects.requireNonNull(getSupportActionBar())
//                   .setTitle(coordinatesExcerpt);
//            textView.setText(Html.fromHtml(textExcerpt));
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_excerpt_dialog_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.idClose:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
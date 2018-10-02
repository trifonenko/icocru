package ru.app.churchofchrist.foundations_of_christianity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.app.churchofchrist.R;

import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class VerseDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_dialog);

        Uri uri = getIntent().getData();

        String caption = uri.getQueryParameter("caption");
        String text = uri.getQueryParameter("text");

        Toolbar toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        toolbar.setTitle(caption);

        TextView textView = findViewById(R.id.text);
        textView.setText(Html.fromHtml(text));
    }
}
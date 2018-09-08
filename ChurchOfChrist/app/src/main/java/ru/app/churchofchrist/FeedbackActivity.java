package ru.app.churchofchrist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    Button send;
    EditText emailtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Toolbar toolbar = findViewById(R.id.idToolbar);
        toolbar.setTitle("Обратная связь");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Наши поля и кнопка
        send = findViewById(R.id.emailsendbutton);
        emailtext = findViewById(R.id.emailtext);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailSelectorIntent = new Intent(Intent.ACTION_SENDTO);
                emailSelectorIntent.setData(Uri.parse("mailto:"));

                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"nskcoc@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Отзыв и предложение");
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailtext.getText().toString());
                emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                emailIntent.setSelector( emailSelectorIntent );


                if( emailIntent.resolveActivity(getPackageManager()) != null )
                    startActivity(emailIntent);

            }
        });
    }
}
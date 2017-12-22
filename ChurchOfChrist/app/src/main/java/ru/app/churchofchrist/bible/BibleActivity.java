package ru.app.churchofchrist.bible;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.io.IOException;

import ru.app.churchofchrist.R;


public class BibleActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    String[] books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nrt_bible);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        String product = "";

        Cursor cursor = mDb.rawQuery("SELECT * FROM books", null);
        cursor.moveToFirst();

        int i = 0;
        books = new String[66];
        while (!cursor.isAfterLast()) {
            books[i] = cursor.getString(3);
            i++;
            cursor.moveToNext();
        }
        cursor.close();

        Spinner listBooks = findViewById(R.id.list_books);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, books);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listBooks.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product = "";

                Cursor cursor = mDb.rawQuery("SELECT * FROM books", null);
                cursor.moveToFirst();
                int i = 0;
                while (!cursor.isAfterLast()) {
                    product += cursor.getString(3) + "\n";
                    cursor.moveToNext();
                    books[i] = product;
                    i++;
                }
                cursor.close();

                textView.setText(product);
            }
        });
    }
}

package ru.app.churchofchrist.random_verse;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.app.churchofchrist.DBHelper;
import ru.app.churchofchrist.R;

/**
 * Фрагмент, представляющий модуль - <i>Случайный стих</i>.
 */
public class RandomVerseFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_random_verse, container, false);

        DBHelper dbHelper = new DBHelper(getActivity(), "lessons.db", 4);//10.04.2018 (версия в google 2)
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        final SQLiteDatabase database = dbHelper.getReadableDatabase();
        this.randomVerse(database);

        ImageView random = view.findViewById(R.id.imageView9);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomVerse(database);
            }
        });

        ImageView share = view.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                TextView verse = view.findViewById(R.id.random_verse);
                TextView coordinatesVerse = view.findViewById(R.id.coordinates_verse);
                String textToSend = verse.getText() + "\n\n" + coordinatesVerse.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                try {
                    startActivity(Intent.createChooser(intent, "Описание действия"));
                } catch (ActivityNotFoundException ignored) {
                }
            }
        });
        return view;
    }

    //Случайный отрывок.
    private void randomVerse(SQLiteDatabase database) {
        Cursor cursor = database.rawQuery("SELECT * FROM bible_verse_s", null);
        Random random = new Random();
        int randomNum = random.nextInt(cursor.getCount());
        cursor.moveToPosition(randomNum);

        TextView verse = view.findViewById(R.id.random_verse);
        verse.setText(cursor.getString(0));
        TextView coordinatesVerse = view.findViewById(R.id.coordinates_verse);
        coordinatesVerse.setText(cursor.getString(1));

        cursor.close();
    }
}
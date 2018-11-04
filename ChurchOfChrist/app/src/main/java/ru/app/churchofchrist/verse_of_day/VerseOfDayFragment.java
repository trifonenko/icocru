package ru.app.churchofchrist.verse_of_day;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.app.churchofchrist.ApplicationManager;
import ru.app.churchofchrist.R;

public class VerseOfDayFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verse_of_day, container, false);

        AppDatabase db = ((ApplicationManager) Objects.requireNonNull(getActivity())
                                                      .getApplicationContext()).getDatabase();
        VerseDao verseDao = db.verseDao();
        Verse verse = verseDao.getVerse();

        BookDao bookDao = db.bookDao();
        Book book = bookDao.getBook(verse.getBoolNumber());

        StringBuilder stringBuilder = new StringBuilder().append(book.getShortName())
                                                         .append(" ")
                                                         .append(verse.getChapter())
                                                         .append(":")
                                                         .append(verse.getVerse());

        TextView textVerseTextView = view.findViewById(R.id.idTextVerseOfDay);
        textVerseTextView.setText(editTextVerse(verse.getText()));

        TextView coordinatesVerseTextView = view.findViewById(R.id.idCoordinatesVerseOfDay);
        coordinatesVerseTextView.setText(stringBuilder);

        ImageView shapeVerseImageView = view.findViewById(R.id.idShareVerseOfDay);
        shapeVerseImageView.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(verse.getText()) + "\n" + stringBuilder);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });

        return view;
    }

    private CharSequence editTextVerse(CharSequence textVerse) {
        Pattern pattern = Pattern.compile("\\[\\d*]");
        return Html.fromHtml(pattern.matcher(textVerse)
                                    .replaceAll(""));
    }
}
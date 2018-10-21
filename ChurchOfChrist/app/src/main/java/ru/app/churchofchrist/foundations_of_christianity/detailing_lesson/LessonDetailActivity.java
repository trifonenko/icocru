package ru.app.churchofchrist.foundations_of_christianity.detailing_lesson;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.app.churchofchrist.R;

public class LessonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);

        IContract.IPresenterLessonDetail presenter = new PresenterLessonDetail(this);

        Intent intent = getIntent();
        String titleLesson = intent.getStringExtra("lesson");

        Toolbar toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        toolbar.setTitle(titleLesson);

        String text = presenter.getLessonText(titleLesson);

        SpannableString spannableString = new SpannableString(text);

        String[] strings = new String[]{"Иов 26:8", "Иов 36:26-29"};
        for (String itemVerse : strings) {
            spannableString.setSpan(new VerseClickableSpan(this), text.indexOf(itemVerse), text.indexOf(itemVerse) +
                    itemVerse.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        TextView lessonTextView = findViewById(R.id.idLessonTextView);
        lessonTextView.setText(spannableString, TextView.BufferType.SPANNABLE);
        lessonTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
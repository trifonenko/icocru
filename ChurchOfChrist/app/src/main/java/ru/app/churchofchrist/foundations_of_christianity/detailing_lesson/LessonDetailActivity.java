package ru.app.churchofchrist.foundations_of_christianity.detailing_lesson;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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

        TextView lessonTextView = findViewById(R.id.idLessonTextView);
        lessonTextView.setText(Html.fromHtml(presenter.getLessonText(titleLesson)));
    }
}
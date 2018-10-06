package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;
import android.text.Html;
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

        Lesson lesson = getIntent().getParcelableExtra("lesson");

        Toolbar toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        toolbar.setTitle(lesson.getTitle());

        TextView lessonTextView = findViewById(R.id.idLessonTextView);

        lessonTextView.setText(Html.fromHtml(lesson.getLessonText()));

        lessonTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
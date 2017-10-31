package ru.app.churchofchrist.ox;
import android.text.style.ClickableSpan;
import android.view.View;

public class ArticleSpan extends ClickableSpan {

    final OxDetail1Activity activity;
    final String articleId;

    public ArticleSpan(OxDetail1Activity activity, String articleId) {
        super();
        this.activity = activity;
        this.articleId = articleId;
    }

    @Override
    public void onClick(View arg0) {
        activity.setLesson(articleId);
    }

}

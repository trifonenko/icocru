package ru.app.churchofchrist.news;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.app.churchofchrist.R;

public class NewsDetailActivity extends AppCompatActivity {

    public final static String KEY_INTENT_INDEX_LIST_NEWS = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(v -> finish());

        NewsSingleton newsSingleton = NewsSingleton.getInstance();
        List<News> newsList = newsSingleton.getNewsList();

        Intent intent = getIntent();
        int index = intent.getIntExtra(KEY_INTENT_INDEX_LIST_NEWS, 0);

        TextView titleNews = findViewById(R.id.idTitleNews);
        titleNews.setText(newsList.get(index)
                                  .getTitle());

        ImageView imageNews = findViewById(R.id.idImageNews);
        Picasso.get()
               .load(newsList.get(index)
                             .getImageUri())
               .placeholder(R.drawable.bg_card)
               .into(imageNews);

        TextView description = findViewById(R.id.idTextNews);
        description.setText(newsList.get(index)
                                    .getDescription());
    }
}
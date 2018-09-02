package ru.app.churchofchrist.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.app.churchofchrist.R;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private List<News> mNews;

    NewsRecyclerViewAdapter(List<News> mNews) {
        this.mNews = mNews;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind(mNews.get(position));
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageNews;
        private TextView titleNews;

        ViewHolder(View itemView) {
            super(itemView);
            imageNews = itemView.findViewById(R.id.idImageNews);
            titleNews = itemView.findViewById(R.id.idTitleNews);
        }

        void bind(News news) {
            titleNews.setText(news.getTitle());
            Picasso.get()
                    .load(news.getImageUri())
                    .into(imageNews);
        }
    }
}
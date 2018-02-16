package ru.app.churchofchrist.good_news;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Drawable mDrawable;
    private String mTitle;
    private String mBody;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private ConstraintLayout mRoot;

        ViewHolder(ConstraintLayout itemView) {
            super(itemView);
            //mRoot = itemView;
        }
    }

    public GoodNewsRecyclerViewAdapter(Drawable drawable, String title, String body) {
        this.mDrawable = drawable;
        this.mTitle = title;
        this.mBody = body;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recucler_view_good_news, parent, false);
        return new ViewHolder(constraintLayout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.itemView;
        ImageView icon = constraintLayout.findViewById(R.id.icon_good_news);
        icon.setImageDrawable(mDrawable);
        TextView title = constraintLayout.findViewById(R.id.title_good_news);
        title.setText(mTitle);
        TextView body = constraintLayout.findViewById(R.id.body_good_news);
        body.setText(mBody);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

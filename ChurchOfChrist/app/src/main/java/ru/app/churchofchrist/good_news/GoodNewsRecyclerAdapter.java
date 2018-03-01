package ru.app.churchofchrist.good_news;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsRecyclerAdapter extends RecyclerView.Adapter<GoodNewsRecyclerAdapter.ViewHolder> {

    private String[] mCaptions;
    private String[] mNew;
    private String[] mLinksImg;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mCv;

        ViewHolder(CardView cv) {
            super(cv);
            mCv = cv;
        }
    }

    GoodNewsRecyclerAdapter(String[] captions, String[] aNew, String[] linksImg) {
        this.mCaptions = captions;
        this.mNew = aNew;
        this.mLinksImg = linksImg;
    }

    @Override
    public GoodNewsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recucler_view_good_news, parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cv = holder.mCv;

        Uri uri;
        if (mLinksImg[position].contains("youtube")) {
            uri = Uri.parse("http://www.icocnews.ru/wp-content/uploads/2017/11/783636-1200x575.jpg");
        } else {
            uri = Uri.parse(mLinksImg[position]);
        }
        SimpleDraweeView drawView = cv.findViewById(R.id.img);
        drawView.setImageURI(uri);

        TextView caption = cv.findViewById(R.id.captions_good_news);
        caption.setText(mCaptions[position]);

        TextView aNew = cv.findViewById(R.id.body_good_news);
        aNew.setText(mNew[position]);
    }

    @Override
    public int getItemCount() {
        return mCaptions.length;
    }
}
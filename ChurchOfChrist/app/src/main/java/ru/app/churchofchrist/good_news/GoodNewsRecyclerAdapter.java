package ru.app.churchofchrist.good_news;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsRecyclerAdapter extends RecyclerView.Adapter<GoodNewsRecyclerAdapter.ViewHolder> {

    private String[] mCaptions;
    private String[] mNew;
    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mCv;

        ViewHolder(CardView cv) {
            super(cv);
            mCv = cv;
        }
    }

    public GoodNewsRecyclerAdapter(String[] captions, String[] aNew) {
        this.mCaptions = captions;
        this.mNew = aNew;
    }

    @Override
    public GoodNewsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recucler_view_good_news, parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cv = holder.mCv;
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
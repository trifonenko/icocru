package ru.app.churchofchrist.goodnews;

import android.support.constraint.ConstraintLayout;
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout mCl;

        ViewHolder(ConstraintLayout cl) {
            super(cl);
            mCl = cl;
        }
    }

    public GoodNewsRecyclerAdapter(String[] captions) {
        this.mCaptions = captions;
    }

    @Override
    public GoodNewsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout cl = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recucler_view_good_news, parent, false);
        return new ViewHolder(cl);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        ConstraintLayout cl = holder.mCl;
        TextView textView = cl.findViewById(R.id.title_good_news);
        textView.setText(mCaptions[position]);
    }

    @Override
    public int getItemCount() {
        return mCaptions.length;
    }
}
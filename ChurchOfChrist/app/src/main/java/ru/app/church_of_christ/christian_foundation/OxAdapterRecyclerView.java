package ru.app.church_of_christ.christian_foundation;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.church_of_christ.OnClickListenerAdapter;
import ru.app.church_of_christ.R;

class OxAdapterRecyclerView extends RecyclerView.Adapter<OxAdapterRecyclerView.ViewHolder> {

    private String[] titles;
    private OnClickListenerAdapter listener;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    OxAdapterRecyclerView(String[] titles) {
        this.titles = titles;
    }

    public void setOnClickListenerAdapter(OnClickListenerAdapter listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public OxAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_list, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull OxAdapterRecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;
        TextView textView = cardView.findViewById(R.id.title_lesson);
        textView.setText(titles[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClickItemAdapter(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}

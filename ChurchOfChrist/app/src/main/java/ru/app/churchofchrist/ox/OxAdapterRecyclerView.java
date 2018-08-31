package ru.app.churchofchrist.ox;

/* Адаптер RecyclerView. */

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

class OxAdapterRecyclerView extends RecyclerView.Adapter<OxAdapterRecyclerView.ViewHolder> {

    private String[] titles;

    private Listener listener;
    interface Listener {
        void onClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    OxAdapterRecyclerView(String[] titles){
        this.titles = titles;
    }
    public void setListener(Listener listener){
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
        TextView textView = cardView.findViewById(R.id.name_title);
        textView.setText(titles[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}

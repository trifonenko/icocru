package ru.app.churchofchrist.ansver;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Адаптер для RecyclerView.
 */

public class AnsverListAdapter extends RecyclerView.Adapter<AnsverListAdapter.ViewHolder> {

    private String[] captions;
    private Listener listener;
    public interface Listener {
        void onClick(CharSequence ansverName);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    AnsverListAdapter(String[] captions){
        this.captions = captions;
    }


    void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public AnsverListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_ansver_list, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;
        final TextView textView = cardView.findViewById(R.id.ansver_name_list);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence ansverName = textView.getText();
                if (listener != null) {
                    listener.onClick(ansverName);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }
}

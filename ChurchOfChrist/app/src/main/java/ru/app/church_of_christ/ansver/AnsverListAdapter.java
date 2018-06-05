package ru.app.church_of_christ.ansver;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.app.church_of_christ.R;

/**
 * Адаптер для RecyclerView.
 */

public class AnsverListAdapter extends RecyclerView.Adapter<AnsverListAdapter.ViewHolder> {

    private List<Ansver> mAnsver;
    private Listener listener;

    public interface Listener {
        void onClick(int ansverId);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    AnsverListAdapter(List<Ansver> ansver) {this.mAnsver = ansver;
    }


    void setListener(Listener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnsverListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_ansver_list, parent, false);
        return new ViewHolder(cv);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;
        final TextView text = cardView.findViewById(R.id.ansver_name_list);
        final TextView id = cardView.findViewById(R.id.ansver_id);
        id.setText("" + mAnsver.get(position).getId());
        text.setText(mAnsver.get(position).getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence ansverName = text.getText();
                if (listener != null) {
                    listener.onClick(mAnsver.get(position).getId() - 1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {return mAnsver.size();}
}

package ru.app.churchofchrist.notepad;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.app.churchofchrist.R;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList <DataModel> dataModels;
    private int tableNumber;

    RvAdapter(Activity activity, ArrayList<DataModel> dataModels, int tableNumber) {
        this.activity = activity;
        this.dataModels = dataModels;
        this.tableNumber = tableNumber;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final DataModel dataModel = dataModels.get(position);

        // Текст карточки
        holder.textViewTheme.setText(dataModel.getTheme());
        holder.textViewDate.setText(dataModel.getDate());

        // Цвет карточки
        switch (dataModel.getColor()) {
            case "color0": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color0)); break;
            case "color1": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color1)); break;
            case "color2": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color2)); break;
            case "color3": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color3)); break;
            case "color4": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color4)); break;
            case "color5": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color5)); break;
            case "color6": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color6)); break;
            case "color7": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color7)); break;
            case "color8": holder.cardViewColor.setCardBackgroundColor(ContextCompat.getColor(activity, R.color.color8)); break;
        }

        // Клик
        holder.cardViewColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Переход к заметке
                Intent intent = new Intent(activity, NoteActivity.class);
                intent.putExtra("Action", "UPDATE");
                intent.putExtra("Id", dataModel.getId());
                intent.putExtra("TableNumber", tableNumber);
                activity.startActivity(intent);
                activity.finish();
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataModels.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTheme;
        TextView textViewDate;
        CardView cardViewColor;

        ViewHolder(View itemView) {
            super(itemView);

            textViewTheme = (TextView) itemView.findViewById(R.id.textViewTheme);
            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            cardViewColor = (CardView) itemView.findViewById(R.id.cardView);
        }

    }
}

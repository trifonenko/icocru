package ru.app.churchofchrist.foundations_of_christianity.detailing_lesson;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class VerseClickableSpan extends ClickableSpan {

    private Context mContext;

    VerseClickableSpan(Context context) {
        this.mContext = context;
    }

    @Override
    public void onClick(@NonNull View view) {
        TextView textView = (TextView) view;
        Toast.makeText(mContext, textView.getText() + "", Toast.LENGTH_SHORT).show();
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setPositiveButton("ok", (dialog, id) -> {
//
//        });
//        builder.setNegativeButton("cancel", (dialog, id) -> {
//        });
//        builder.create().show();
    }
}
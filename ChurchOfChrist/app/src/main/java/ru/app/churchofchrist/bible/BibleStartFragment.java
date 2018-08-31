package ru.app.churchofchrist.bible;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.app.churchofchrist.R;

public class BibleStartFragment extends Fragment {
    private TextView textViewDate;
    private TextView textViewAdr;

    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bible_start, container, false);
        textViewDate = view.findViewById(R.id.textViewDate);
        textViewAdr = view.findViewById(R.id.textViewAdr);

        Button button1 = view.findViewById(R.id.button_sovr);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BibleActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = view.findViewById(R.id.button_sinod);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BibleActivity2.class);
                startActivity(intent);
            }
        });

        BibleStartFragment.MyTask mt = new BibleStartFragment.MyTask();
        mt.execute();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd MMMM");
        textViewDate.setText("Чтение на сегодня (" + dateFormat.format( currentDate ) + ")");
        return view;
    }

    @SuppressLint("StaticFieldLeak")
    class MyTask extends AsyncTask<Void, Void, Void> {

        String adr;

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("http://bibleplan.ru/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc != null) {
                Elements elements = doc.select("span.header-plan-chapters");
                adr = elements.get(0).text();
            } else
                adr = "Требуется подключение к интернету";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewAdr.setText(adr);
        }
    }
}
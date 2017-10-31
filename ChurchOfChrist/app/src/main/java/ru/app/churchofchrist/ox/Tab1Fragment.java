package ru.app.churchofchrist.ox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.app.churchofchrist.R;

/* Первые принципы. */

public class Tab1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] arrayTitles = new String[Lesson.lessonFirstPrinciples.length];
        for (int i = 0; i < arrayTitles.length; i++) {
            arrayTitles[i] = Lesson.lessonFirstPrinciples[i].getName();
        }
        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_tab1, container, false);
        OxAdapterRecyclerView adapter = new OxAdapterRecyclerView(arrayTitles);
        recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        adapter.setListener(new OxAdapterRecyclerView.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), OxDetail1Activity.class);
                intent.putExtra(OxDetail1Activity.KEY1, position);
                getActivity().startActivity(intent);
            }
        });
        return recycler;
    }
}

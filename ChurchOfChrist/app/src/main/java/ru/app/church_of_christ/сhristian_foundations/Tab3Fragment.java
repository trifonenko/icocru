package ru.app.church_of_christ.сhristian_foundations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.app.church_of_christ.OnClickListenerAdapter;
import ru.app.church_of_christ.R;

/* Характер Иисуса. */

public class Tab3Fragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] arrayTitles = new String[Lesson.lessonCharacterJesus.length];
        for (int i = 0; i < arrayTitles.length; i++) {
            arrayTitles[i] = Lesson.lessonCharacterJesus[i].getName();
        }
        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_tab3, container, false);
        OxAdapterRecyclerView adapter = new OxAdapterRecyclerView(arrayTitles);
        recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        adapter.setOnClickListenerAdapter(new OnClickListenerAdapter() {
            public void onClickItemAdapter(int position) {
                Intent intent = new Intent(getActivity(), OxDetail1Activity.class);
                intent.putExtra(OxDetail1Activity.KEY3, position);
                getActivity().startActivity(intent);
            }
        });
        return recycler;
    }
}

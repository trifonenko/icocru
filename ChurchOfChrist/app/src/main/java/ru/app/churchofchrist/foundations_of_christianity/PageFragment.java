package ru.app.churchofchrist.foundations_of_christianity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import io.reactivex.Observable;

public class PageFragment extends ListFragment implements IContract.IView {

    private List<Lesson> lessons;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        int position = 0;
        if (bundle != null) {
            position = bundle.getInt("position");
        }

        //TODO Это можно сделать как то чище
        String nameTable = "";
        switch (position) {
            case 0:
                nameTable = "lessons_foundation_of_christianity";
                break;
            case 1:
                nameTable = "lessons_retrieval";
                break;
            case 2:
                nameTable = "lessons_character_of_jesus";
                break;
            case 3:
                nameTable = "lesson_young_students";
                break;
        }

        PresenterImpl presenter = new PresenterImpl(getActivity(), this);
        lessons = presenter.getListLessons(nameTable);

        List<String> titlesLessons = Observable.fromIterable(lessons)
                                               .map(Lesson::getTitle)
                                               .toList()
                                               .blockingGet();
        ListAdapter adapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1,
                titlesLessons
        );
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), LessonDetailActivity.class);
        intent.putExtra("lesson", lessons.get(position));
        startActivity(intent);
    }
}
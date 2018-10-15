package ru.app.churchofchrist.foundations_of_christianity.lessons_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import ru.app.churchofchrist.foundations_of_christianity.LessonDetailActivity;

public class PageFragment extends ListFragment implements IContract.IView {

    private List<String> titlesLessons;
    private List<String> list;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        int topicLessons = 0;
        if (bundle != null) {
            topicLessons = bundle.getInt("position");
        }

        PresenterImpl presenter = new PresenterImpl(getActivity(), this);
        list = presenter.getTopics();

        titlesLessons = presenter.loadListTitles(presenter.getTopics().get(topicLessons));

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
        intent.putExtra("lesson", titlesLessons.get(position));
        startActivity(intent);
    }
}
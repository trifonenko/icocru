package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.reactivex.Observable;
import ru.app.churchofchrist.R;

public class FoundationOfChristianityFragment extends Fragment implements IContract.IView {

    private ListView mListView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foundation_of_christianity, container, false);
        mListView = view.findViewById(R.id.idListViewLessons);
        showLessons(new ArrayList<>());
        return view;
    }

    @Override
    public void showLessons(List<Lesson> lessonList) {
        List<String> titlesLessons = Observable.fromIterable(lessonList)
                                               .map(Lesson::getTitle)
                                               .toList()
                                               .blockingGet();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                titlesLessons
        );
        mListView.setAdapter(adapter);
    }
}
package ru.app.churchofchrist.foundations_of_christianity.lessons_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import ru.app.churchofchrist.foundations_of_christianity.detailing_lesson.LessonDetailActivity;

public class LessonsListFragment extends ListFragment implements IContract.IView {

    private String mTopicLesson;

    /**
     * Метод создает фрагмент со списком уроков, который приминяется в ViewPager.
     *
     * @param topicLessons тема, по которой формируется список уроков
     * @return новый объект LessonsListFragment
     */
    public static LessonsListFragment newInstance(String topicLessons) {
        LessonsListFragment lessonsListFragment = new LessonsListFragment();
        Bundle bundleArgs = new Bundle();
        bundleArgs.putString("topicLessons", topicLessons);
        lessonsListFragment.setArguments(bundleArgs);
        return lessonsListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTopicLesson = getArguments() != null ? getArguments().getString("topicLessons") : "";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        IContract.IPresenter presenter = new PresenterImpl(getActivity(), this);
        List<String> titlesLessonsList = presenter.loadListTitles(mTopicLesson);

        ListAdapter adapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1,
                titlesLessonsList
        );
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), LessonDetailActivity.class);
        intent.putExtra("lesson", mTopicLesson);
        startActivity(intent);
    }
}
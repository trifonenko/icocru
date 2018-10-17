package ru.app.churchofchrist.foundations_of_christianity.pager_adapter;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import androidx.fragment.app.Fragment;
import ru.app.churchofchrist.foundations_of_christianity.ModelImpl;
import ru.app.churchofchrist.foundations_of_christianity.lessons_list.IContract.IModel;
import ru.app.churchofchrist.foundations_of_christianity.lessons_list.PageFragment;

public class PresenterPagerAdapter implements IContract.IPresenter {

    private List<String> topicsLessons;

    PresenterPagerAdapter(Context context) {
        IModel model = new ModelImpl(context);
        this.topicsLessons = model.loadTopicsLessons();
    }

    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("topicLesson", topicsLessons.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return topicsLessons.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return topicsLessons.get(position);
    }
}
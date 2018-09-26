package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.app.churchofchrist.R;

public class FoundationOfChristianityFragment extends Fragment implements IContract.IView {

    private ListView mListView;
    private PresenterImpl mPresenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foundation_of_christianity, container, false);
        mPresenter = new PresenterImpl(getActivity(), this);

        mListView = view.findViewById(R.id.idListViewLessons);

        TabLayout tabLayout = view.findViewById(R.id.idTabLayoutFoundationOfChristianity);
        tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);
        return view;
    }

    @Override
    public void showListLessons(List<String> titlesLessons) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                titlesLessons
        );
        mListView.setAdapter(adapter);
    }

    private TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mPresenter.onTabSelected(tab.getContentDescription());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
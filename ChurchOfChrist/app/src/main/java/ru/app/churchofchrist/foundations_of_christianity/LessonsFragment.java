package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import ru.app.churchofchrist.R;
import ru.app.churchofchrist.foundations_of_christianity.pager_adapter.PagerAdapter;

public class LessonsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lessons, container, false);

        PagerAdapter pagerAdapter = new PagerAdapter(
                Objects.requireNonNull(getActivity())
                        .getSupportFragmentManager(), getActivity().getApplicationContext()
        );

        ViewPager viewPager = view.findViewById(R.id.idViewPagerLessons);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.idTabLayoutLessons);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
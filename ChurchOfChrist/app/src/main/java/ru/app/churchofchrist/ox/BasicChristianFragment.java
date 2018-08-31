package ru.app.churchofchrist.ox;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import ru.app.churchofchrist.MainActivity;
import ru.app.churchofchrist.R;
import ru.app.churchofchrist.ViewPagerAdapter;

public class BasicChristianFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_christian, container, false);

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toolbar toolbar = ((MainActivity) context).findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.basic_christian);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(((MainActivity) context).getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Основы Христианства");
        adapter.addFragment(new Tab2Fragment(), "Возвращение");
        adapter.addFragment(new Tab3Fragment(), "Характер Иисуса");
        adapter.addFragment(new Tab4Fragment(), "Молодые ученики");
        viewPager.setAdapter(adapter);
    }
}
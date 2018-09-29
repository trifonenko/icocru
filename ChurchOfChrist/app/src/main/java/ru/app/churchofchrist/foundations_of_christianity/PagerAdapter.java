package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    //TODO Убрать это!!! Тему уроков брать из class Lesson, соответственно таблицы всех уроков объединить
    private String[] titlesTab = {"Основы христианства", "Возвращение", "Характер Иисуса", "Молодые ученики"};

    PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return titlesTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        return titlesTab[position];
    }
}
package ru.app.churchofchrist.notepad;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.util.Log;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final FragmentMain fragmentMain = new FragmentMain();
    private final FragmentFavorites fragmentFavorites = new FragmentFavorites();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("MyTag", "------------SectionsPagerAdapter-----------");
        switch(position){
            case 0:
                return fragmentMain;
            case 1:
                return fragmentFavorites;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "0";
            case 1:
                return "1";
        }
        return null;
    }
}
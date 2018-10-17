package ru.app.churchofchrist.foundations_of_christianity.pager_adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private IContract.IPresenter presenterPagerAdapter;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.presenterPagerAdapter = new PresenterPagerAdapter(context);
    }

    @Override
    public Fragment getItem(int position) {
        return presenterPagerAdapter.getItem(position);
    }

    @Override
    public int getCount() {
        return presenterPagerAdapter.getCount();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        return presenterPagerAdapter.getPageTitle(position);
    }
}
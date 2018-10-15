package ru.app.churchofchrist.foundations_of_christianity.pager_adapter;

import androidx.fragment.app.Fragment;

public interface IContract {

    interface IPresenter {
        Fragment getItem(int position);

        int getCount();

        CharSequence getPageTitle(int position);
    }
}

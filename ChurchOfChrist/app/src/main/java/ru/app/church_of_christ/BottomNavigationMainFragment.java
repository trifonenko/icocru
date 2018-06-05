package ru.app.church_of_christ;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomNavigationMainFragment extends Fragment {
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_navigation_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toolbar toolbar = ((MainActivity) context).findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }
}

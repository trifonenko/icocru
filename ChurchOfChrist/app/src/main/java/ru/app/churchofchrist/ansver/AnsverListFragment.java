package ru.app.churchofchrist.ansver;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Список песен.
 */
public class AnsverListFragment extends Fragment {

    interface AnsverListListener {
        void onItemClicked(CharSequence ansverName);
    }

    private AnsverListListener listener;
    private RecyclerView mAnsverRecyclerView;
    private List<Ansver> ansver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        mAnsverRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_ansver_list, container, false);

        AnsverLab ansverLab = AnsverLab.getInstance(getActivity());
        ansver = ansverLab.getAnsver();
        String[] names = new String[ansver.size()];

        for (int i = 0; i < ansver.size(); i++) {
            names[i] = ansver.get(i).getName();
        }

        AnsverListAdapter adapter = new AnsverListAdapter(names);
        mAnsverRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mAnsverRecyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new AnsverListAdapter.Listener() {
            public void onClick(CharSequence ansverName) {
                if (listener != null) {
                    listener.onItemClicked(ansverName);
                }
            }
        });
        return mAnsverRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (AnsverListListener) context;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search_ansver, menu);
        MenuItem searchItem = menu.findItem(R.id.search_ansver);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAnsverRecyclerView.getAdapter().notifyDataSetChanged();
                ArrayList<String> ansverListArray = new ArrayList<>();

                for (Ansver item : ansver) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        ansverListArray.add(item.getName());
                    }
                }
                String[] names = new String[ansverListArray.size()];
                for (int i = 0; i < ansverListArray.size(); i++) {
                    names[i] = ansverListArray.get(i);
                }

                AnsverListAdapter adapter = new AnsverListAdapter(names);
                mAnsverRecyclerView.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                mAnsverRecyclerView.setLayoutManager(layoutManager);
                adapter.setListener(new AnsverListAdapter.Listener() {
                    public void onClick(CharSequence ansverName) {
                        if (listener != null) {
                            listener.onItemClicked(ansverName);
                        }
                    }
                });
                return true;
            }


        });
    }
}

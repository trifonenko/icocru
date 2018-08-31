package ru.app.churchofchrist.ansver;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.app.churchofchrist.R;


public class AnsverListFragment extends Fragment {

    interface AnsverListListener {
        void onItemClicked(int ansverId);
    }

    private AnsverListListener listener;
    private RecyclerView mAnsverRecyclerView;
    private List<Ansver> ansver;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        mAnsverRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_ansver_list, container, false);

        AnsverLab ansverLab = AnsverLab.getInstance(getActivity());
        ansver = ansverLab.getAnsver();
        onRunAnsver(ansver);
        return mAnsverRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (AnsverListListener) context;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Ansver> ansverFilter = new ArrayList<>();

                for (Ansver ansver : ansver) {
                    if (searchAnsver(ansver, newText)) {
                        ansverFilter.add(ansver);
                    }
                }
                onRunAnsver(ansverFilter);
                return true;
            }


        });
    }
    private void onRunAnsver(List<Ansver> ansver) {
        AnsverListAdapter adapter = new AnsverListAdapter(ansver);
        mAnsverRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mAnsverRecyclerView.setLayoutManager(layoutManager);
        adapter.setListener(new AnsverListAdapter.Listener() {
            public void onClick(int ansverId) {
                if (listener != null) {
                    listener.onItemClicked(ansverId);
                }
            }
        });
    }
    //Поиск песен по списку имен.
    private boolean searchAnsver(Ansver ansver, String newText) {
        String regex = "\\s|,|!|\\(|\\)|\\.|-|_";//Регулярное выражение.
        String ansverName = ansver.getName();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNewText = pattern.matcher(newText);
        newText = (matcherNewText.replaceAll("")).toLowerCase();
        Matcher matcherAnsverName = pattern.matcher(ansverName);
        ansverName = (matcherAnsverName.replaceAll("")).toLowerCase();
        return ansverName.contains(newText);
    }
}

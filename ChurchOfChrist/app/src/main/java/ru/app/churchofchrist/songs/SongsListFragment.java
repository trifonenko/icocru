package ru.app.churchofchrist.songs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.app.churchofchrist.R;

/**
 * Фрагмент, отображающий список песен.
 */
public class SongsListFragment extends ListFragment {

    static interface SongListListener {
        void onItemClicked(long id);
    }

    private SongListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] names = new String[Song.getArrayListNameSongs().length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Song.getArrayListNameSongs()[i];
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SongListListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if (listener != null) {
            listener.onItemClicked(id);
        }
    }
}

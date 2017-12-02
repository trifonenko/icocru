package ru.app.churchofchrist.songs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Список песен.
 */
public class SongsListFragment extends Fragment {

    interface SongListListener {
        void onItemClicked(long id);
    }

    private SongListListener listener;
    private RecyclerView mSongsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_songs_list, container, false);
        String[] pizzaNames = new String[Song.getArraySongs().length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Song.getArraySongs()[i].getName();
        }

        SongsListAdapter adapter = new SongsListAdapter(pizzaNames);
        pizzaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (SongListListener) context;
    }

    private class CrimeHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;
        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    //@Override
   // public void onListItemClick(ListView l, View v, int position, long id){
        //if (listener != null) {
            //listener.onItemClicked(id);
       // }
    //}
}

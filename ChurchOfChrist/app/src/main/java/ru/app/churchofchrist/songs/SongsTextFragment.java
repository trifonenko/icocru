package ru.app.churchofchrist.songs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import ru.app.churchofchrist.R;

/**
 * Фрагмент, для отображения детализации песен.
 */
public class SongsTextFragment extends Fragment {

    private long songId;//Идентификатор песни, выбранной пользователем.
    int temp = 14;
    public static final String APP_PREFERENCES = "mysettingss";
    TextView songText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        temp = sharedPref.getInt("temp", temp);
        setHasOptionsMenu(true);
        if (savedInstanceState != null) {
            songId = savedInstanceState.getLong("songId");
        }
        return inflater.inflate(R.layout.fragment_songs_text, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Song song = Song.getArraySongs()[(int) songId];
            TextView songName = view.findViewById(R.id.song_name);
            songName.setText(song.getName());
            songText = view.findViewById(R.id.song_text);
            songText.setText(song.getText());



                songText.setTextSize((float) temp);//Размер текста песни.


        }
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("temp", temp);
        editor.apply();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("songId", songId);
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_song_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inf = getActivity().getLayoutInflater();
                View view = inf.inflate(R.layout.dialog, null);
                builder.setView(view)
                        .setTitle("Размер шрифта")
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                final TextView text = view.findViewById(R.id.textView);
                text.setText(String.valueOf(temp));
                SeekBar seekBar = view.findViewById(R.id.seekBar);
                seekBar.setProgress(temp - 10);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        songText.setTextSize(progress + 10);
                        text.setText(String.valueOf(progress + 10));
                        temp = progress + 10;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

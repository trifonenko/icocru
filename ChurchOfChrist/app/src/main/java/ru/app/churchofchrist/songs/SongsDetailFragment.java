package ru.app.churchofchrist.songs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import ru.app.churchofchrist.R;

/**
 * Фрагмент, для отображения детализации песен.
 */
public class SongsDetailFragment extends Fragment {

    private int songId;//Идентификатор песни, выбранной пользователем.
    private int temp = 14;
    private TextView songText;
    private TextView songName;
    private TextView songTextId;
    private List<Song> songs;
    private SwitchCompat compat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        temp = sharedPref.getInt("temp", temp);
        setHasOptionsMenu(true);
        if (savedInstanceState != null) {
            songId = savedInstanceState.getInt("songId");
        }
        return inflater.inflate(R.layout.fragment_songs_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            SongsLab songsLab = SongsLab.getInstance(getActivity());
            songs = songsLab.getSongs();
            songName = view.findViewById(R.id.song_name);
            songText = view.findViewById(R.id.song_text);
            songTextId = view.findViewById(R.id.song_id);
            compat = view.findViewById(R.id.chords_switch);
            compat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        songText.setText(songs.get(songId).getChords());
                    } else {
                        songText.setText(songs.get(songId).getText());
                    }
                }
            });
            onRunSong(songId);
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
        savedInstanceState.putInt("songId", songId);
    }

    public void setSongId(int songId) {
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
                @SuppressLint("InflateParams") View view = inf.inflate(R.layout.dialog, null);
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
            case R.id.random_song:
                Random random = new Random();
                int randomNum = random.nextInt(songs.size() - 1);
                onRunSong(randomNum);
                compat.setChecked(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void onRunSong(int num) {
        songId = num;
        songName.setText(songs.get(num).getName());
        songText.setText(songs.get(num).getText());
        songTextId.setText(songs.get(num).getId() + "");
    }
}

package ru.app.church_of_christ.songs;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import ru.app.church_of_christ.DBHelper;
import ru.app.church_of_christ.R;

/**
 * Фрагмент, для отображения детализации песни.
 */
public class SongsDetailFragment extends Fragment {

    private int songId;//Идентификатор песни, выбранная пользователем.
    private TextView songText;
    private TextView songName;
    private TextView songTextId;
    private int temp = 14;
    private DBHelper mDBHelperFavSongs;
    private List<Song> songs;
    private FloatingActionButton fab;
    private SwitchCompat compat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            songId = savedInstanceState.getInt("songId");
        }
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        temp = sharedPref.getInt("temp", temp);

        setHasOptionsMenu(true);
        mDBHelperFavSongs = new DBHelper(getActivity(), "db_songs", 1);
        return inflater.inflate(R.layout.fragment_songs_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        SongsLab songsLab = SongsLab.getInstance(getActivity());
        songs = songsLab.getSongs();
        final SQLiteDatabase mDatabase = mDBHelperFavSongs.getWritableDatabase();

        final View view = getView();
        if (view != null) {
            songName = view.findViewById(R.id.song_name);
            songName.setText(songs.get(songId).getName());

            songText = view.findViewById(R.id.song_text);
            songText.setTextSize((float) temp);

            songTextId = view.findViewById(R.id.song_id);
            songTextId.setText(String.valueOf(songs.get(songId).getId()));

            compat = view.findViewById(R.id.chords_switch);
            if (compat.isChecked()) {
                songText.setText(songs.get(songId).getChords());
            } else {
                songText.setText(songs.get(songId).getText());
            }
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
            fab = view.findViewById(R.id.floating_button);
            this.fabImageDrawable(fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str;
                    if (isFavSong()) {
                        mDatabase.delete("FAV_SONGS", "ID = ?", new String[]{String.valueOf(songId + 1)});
                        str = "Песня удалена из избранных";
                    } else {
                        insertFavSong(mDatabase, songs.get(songId).getId(), songs.get(songId).getName(), songs.get(songId).getText(), songs.get(songId).getChords());
                        str = "Песня добавлена в избранные";
                    }
                    Snackbar snackbar = Snackbar.make(view, str, Snackbar.LENGTH_LONG);
                    View snackView = snackbar.getView();
                    TextView snackTextView = snackView.findViewById(android.support.design.R.id.snackbar_text);
                    snackTextView.setTextColor(Color.WHITE);
                    snackbar.show();
                    fabImageDrawable(fab);
                }
            });
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

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("songId", songId);
    }

    //Метод для записи данных в таблицу FAV_SONGS бд.
    private static void insertFavSong(SQLiteDatabase db, int id, String name, String text, String chords) {
        ContentValues songValues = new ContentValues();
        songValues.put("ID", id);
        songValues.put("NAME", name);
        songValues.put("TEXT", text);
        songValues.put("CHORDS", chords);
        db.insert("FAV_SONGS", null, songValues);
    }

    //Установка иконки на fab.
    private void fabImageDrawable(FloatingActionButton fab) {
        if (isFavSong())
            fab.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_favorites_on));
        else
            fab.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_favorites_off));
    }

    //Проверка наличия песни в избранных.
    private boolean isFavSong() {
        boolean favoriteSong = false;
        SongsLab songsLab = SongsLab.getInstance(getActivity());
        List<Song> favSongs = songsLab.getFavoritesSongs();
        for (Song song : favSongs) {
            if (song.getId() == songId + 1) favoriteSong = true;
        }
        return favoriteSong;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_songs_detail_fragment, menu);
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
                songId = random.nextInt(songs.size());
                songName.setText(songs.get(songId).getName());
                songText.setText(songs.get(songId).getText());
                songTextId.setText(String.valueOf(songs.get(songId).getId()));
                fabImageDrawable(fab);
                compat.setChecked(false);
                break;
            case R.id.share:
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String textToSend = songName.getText()+ "\n\n" + songText.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                try
                {
                    startActivity(Intent.createChooser(intent, "Описание действия"));
                }
                catch (android.content.ActivityNotFoundException ex) {}
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

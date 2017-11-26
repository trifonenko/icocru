package ru.app.churchofchrist.christiansongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import ru.app.churchofchrist.R;

public class ChristianSongsActivity extends AppCompatActivity {

    private ListView listSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listSongs = (ListView) findViewById(R.id.list_songs);//Устанавливаем связь с созданным ListView:
        //Задаем адаптер, через который выполняется связка массива слов и ListView:
        ArrayAdapter<String> adapterListSongs = new ArrayAdapter<>(this, R.layout.christiansong_item_list, Song.getArrayListNameSongs());
        listSongs.setAdapter(adapterListSongs);//Настраиваем для нашего ListView показ массива с адаптера:
        //Добавим к нашему ListView возможность обработки нажатий на пункты из списка:
        listSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String s = (String) textView.getText();
                runSong(s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_christian_songs, menu);

        MenuItem searchItem = menu.findItem(R.id.search_songs);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setMaxWidth(10000);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> songsListArray = new ArrayList<>();

                for (String item : Song.getArrayListNameSongs()) {
                    if (item.toLowerCase().contains(newText.toLowerCase())) {
                        songsListArray.add(item);
                    }
                }
                listSongs = (ListView) findViewById(R.id.list_songs);
                ArrayAdapter<String> adapterListSongs = new ArrayAdapter<>(ChristianSongsActivity.this, R.layout.christiansong_item_list, songsListArray);
                listSongs.setAdapter(adapterListSongs);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.random_song:
                Random random = new Random();
                int randomNumber = random.nextInt(Song.getArraySongs().length);
                runSong(Song.getArraySongs()[randomNumber].getName());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void runSong(String nameSong) {
        Intent intent = new Intent(ChristianSongsActivity.this, DetailSongActivity.class);
        intent.putExtra(DetailSongActivity.SONG_NAME, nameSong);
        startActivity(intent);
    }
}

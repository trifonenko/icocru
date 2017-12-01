package ru.app.churchofchrist.christiansongs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import ru.app.churchofchrist.R;
import ru.app.churchofchrist.ViewPagerAdapter;

public class DetailSongActivity extends AppCompatActivity {
    private ViewPagerAdapter adapter;
    public static final String SONG_NAME = "name";

    Fragment textFrag = new TextSongFragment();
    Fragment chordsFrag = new ChordsSongFragment();
    Fragment videoFrag = new VideoSongFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_song);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        String songName = (String) getIntent().getExtras().get(SONG_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(songName);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
        TextSongFragment fragment1 = (TextSongFragment) adapter.getItem(0);
        fragment1.setSongName(songName);
        ChordsSongFragment fragment2 = (ChordsSongFragment) adapter.getItem(1);
        fragment2.setSongName(songName);
        VideoSongFragment fragment3 = (VideoSongFragment) adapter.getItem(2);
        fragment3.setSongName(songName);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(textFrag, "Текст");
        adapter.addFragment(chordsFrag, "Аккорды");
        adapter.addFragment(videoFrag, "Видео");
        viewPager.setAdapter(adapter);
    }
}

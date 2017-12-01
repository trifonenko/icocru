package ru.app.churchofchrist.scripture;

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

public class DetailScriptureActivity extends AppCompatActivity {
    private ViewPagerAdapter adapter;
    public static final String SONG_NAME = "name";

    Fragment textFrag = new TextNrpFragment();
    Fragment chordsFrag = new TextSinFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_scripture);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        String songName = (String) getIntent().getExtras().get(SONG_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(songName);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        TextNrpFragment fragment1 = (TextNrpFragment) adapter.getItem(0);
        fragment1.setSongName(songName);
        TextSinFragment fragment2 = (TextSinFragment) adapter.getItem(1);
        fragment2.setSongName(songName);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(textFrag, "Современный");
        adapter.addFragment(chordsFrag, "Синодальный");
        viewPager.setAdapter(adapter);
    }

}

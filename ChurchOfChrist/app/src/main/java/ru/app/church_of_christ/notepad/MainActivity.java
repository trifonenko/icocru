package ru.app.church_of_christ.notepad;
//Блокнот разработан неизвестным специалистом из GitHub. Доработан trifonenko


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import ru.app.church_of_christ.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;
    int sort; // Для сохранения "Сортировка"
    int viewPagerState; // Для сохранения "Позиция пейджера"

    FloatingActionButton fab;
    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    public static DBHelper appDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("MyTag", "------------onCreate-----------");

        savedInstanceState = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notepad);
        appDBHelper = DBHelper.getInstance(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // На экран заметки
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("Action", "INSERT");
                startActivity(intent);
                finish();
            }
        });

        //loadState(); // Загрузка Preferences

        viewPager = findViewById(R.id.container);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Пейджер
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);

        viewPager.setCurrentItem(viewPagerState); // Установка позиции вкладки

        setFavorite(); // Main <-> Favorites

        // Обновление при перелистывании
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {}
            @Override
            public void onPageScrollStateChanged(int state) {

                setFavorite(); // Main <-> Favorites

                // Обновление при перелистывании
                Fragment fragment = sectionsPagerAdapter.getItem(state);
                if (fragment instanceof Updateable) {
                    ((Updateable) fragment).update();
                }

            }
        });

    }


    // Main <-> Favorites
    private void setFavorite () {
        if (viewPager.getCurrentItem() == 0) {
            setTitle(R.string.main_list);
            fab.setVisibility(View.VISIBLE);
        }
        else if (viewPager.getCurrentItem() == 1) {
            setTitle(R.string.favorites_list);
            fab.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onDestroy() {
        Log.d("MyTag", "------------onDestroy-----------");
        saveState(); // Сохранить
        super.onDestroy();
    }


    // Метод сохранения состояния
    public void saveState() {
        sPref = getSharedPreferences("Main" ,MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("Sort", sort); //Сортировка
        ed.putInt("ViewPagerState", viewPager.getCurrentItem()); // Положение пейджера
        ed.apply();
    }
    // Метод загрузки состояния
    public void loadState() {
        sPref = getSharedPreferences("Main" ,MODE_PRIVATE);
        sort = sPref.getInt("Sort", 0); //Сортировка
        viewPagerState = sPref.getInt("ViewPagerState", 0); // Положение пейджера
    }



}

package ru.app.church_of_christ.notepad;
//Блокнот разработан неизвестным специалистом из GitHub. Доработан trifonenko

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.app.church_of_christ.R;

public class FragmentFavorites extends Fragment implements Updateable{

    RecyclerView recyclerView2;
    RecyclerView.Adapter adapter;

    // Лист ArrayList
    ArrayList<DataModel> dataModels = new ArrayList<>();

    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

    SharedPreferences sPref;
    int sort; // Для сохранения "Сортировка"


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("MyTag", "------------onCreateView Favorites-----------");

        View rootView = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView2 = rootView.findViewById(R.id.recyclerView2);

        itemTouchHelper().attachToRecyclerView(recyclerView2); // Смахивание

        loadState();

        dbRead(); // Чтение из базы

        return rootView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Меню
        setHasOptionsMenu(true);
    }


    @Override
    public void onDestroy() {
        saveState();
        super.onDestroy();
    }


    // Чтение из базы
    public void dbRead() {

        // Получение объекта БД
        dbHelper = MainActivity.appDBHelper;

        // Подключение к БД
        db = dbHelper.getWritableDatabase();

        // Запрос всех данных из таблицы. Получение курсора
        switch (sort) {

            case 0: // По порядку добавления
                cursor = db.rawQuery("SELECT * FROM table2 ORDER BY _id DESC;", null);
                //cursor = db.query("table1", null, null, null, null, null, null); // Вариант
                break;
            case 1: // По дате изменения
                cursor = db.rawQuery("SELECT * FROM table2 ORDER BY date_sort DESC;", null);
                break;
            case 2: // По заголовку
                cursor = db.rawQuery("SELECT * FROM table2 ORDER BY theme;", null);
                break;
            case 3: // По цвету
                cursor = db.rawQuery("SELECT * FROM table2 ORDER BY color;", null);
                break;
        }


        // Очистить лист от старых данных
        dataModels.clear();

        // Заполнение данными из базы
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0); // id
            String theme = cursor.getString(1); // Тема
            String date = cursor.getString(3); // Дата
            String color = cursor.getString(4); // Цвет

            // Объект модели данных
            DataModel dataModel = new DataModel(id, theme, date, color);

            // Добавление в лист данных типа <DataModel>
            dataModels.add(dataModel);
        }

        // Закрыть курсор
        if (cursor != null)
            cursor.close();

        // Закрыть подключение к БД
        dbHelper.close();

        // RV
        recyclerView2.setHasFixedSize(true); // Не обязательно

        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext())); // Установка менеджера

        recyclerView2.setItemAnimator(new DefaultItemAnimator()); // Установка анимации

        adapter = new RvAdapter(getActivity(), dataModels, 2); // Объект RV-адаптера

        recyclerView2.setAdapter(adapter); // Установка RV-адаптера

    }


    // Метод для смахивания
    public ItemTouchHelper itemTouchHelper() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                // id строки
                int pos = viewHolder.getAdapterPosition();
                DataModel dataModel = dataModels.get(pos);

                // Подключение к БД
                db = dbHelper.getWritableDatabase();

                // Выбор данных и копирование
                db.execSQL("INSERT INTO table1 SELECT * FROM table2 WHERE _id = ?", new String[]{String.valueOf(dataModel.getId())});

                // Удаление данных
                db.delete("table2", "_id = ?", new String[]{String.valueOf(dataModel.getId())});
                Log.d("LOG_TAG", "---------Delete content_note---------");

                // Закрыть подключение к БД
                dbHelper.close();

                // Чтение из базы
                dbRead();

                // Обновление адаптера
                adapter.notifyDataSetChanged();
            }
        };

        return new ItemTouchHelper(simpleItemTouchCallback);
    }

    // Обновление при перелистывании
    @Override
    public void update() {
        dbRead();
    }


    // Меню
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }
    // Пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // Сортировка
        if (id == R.id.main_sort) {

            String[] sortArr = {
                    getString(R.string.sort_0),
                    getString(R.string.sort_1),
                    getString(R.string.sort_2),
                    getString(R.string.sort_3)
            };

            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.main_sort)
                    .setIcon(R.drawable.ic_sort_black_48dp)
                    // Выход
                    .setItems(sortArr, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {

                            sort = item;
                            dbRead();
                        }
                    })
                    .create().show();

        }
        return super.onOptionsItemSelected(item);
    }


    // Метод сохранения состояния
    public void saveState() {
        sPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("SortFavorites", sort); //Сортировка
        ed.apply();
    }
    // Метод загрузки состояния
    public void loadState() {
        sPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        sort = sPref.getInt("SortFavorites", 0); //Сортировка
    }

}

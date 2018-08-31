package ru.app.churchofchrist.notepad;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.app.churchofchrist.R;

public class FragmentMain extends Fragment implements Updateable{

    RecyclerView recyclerView;
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

        Log.d("MyTag", "------------onCreateView MAIN-----------");

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        itemTouchHelper().attachToRecyclerView(recyclerView); // Смахивание

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
                cursor = db.rawQuery("SELECT * FROM table1 ORDER BY _id DESC;", null);
                //cursor = db.query("table1", null, null, null, null, null, null); // Вариант
                break;
            case 1: // По дате изменения
                cursor = db.rawQuery("SELECT * FROM table1 ORDER BY date_sort DESC;", null);
                break;
            case 2: // По заголовку
                cursor = db.rawQuery("SELECT * FROM table1 ORDER BY theme;", null);
                break;
            case 3: // По цвету
                cursor = db.rawQuery("SELECT * FROM table1 ORDER BY color;", null);
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
        recyclerView.setHasFixedSize(true); // Не обязательно

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // Установка менеджера

        recyclerView.setItemAnimator(new DefaultItemAnimator()); // Установка анимации

        adapter = new RvAdapter(getActivity(), dataModels, 1); // Объект RV-адаптера

        recyclerView.setAdapter(adapter); // Установка RV-адаптера

    }


    // Метод для смахивания
    public ItemTouchHelper itemTouchHelper() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {

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
                db.execSQL("INSERT INTO table2 SELECT * FROM table1 WHERE _id = ?", new String[]{String.valueOf(dataModel.getId())});

                // Удаление данных
                db.delete("table1", "_id = ?", new String[]{String.valueOf(dataModel.getId())});
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
        ed.putInt("SortMain", sort); //Сортировка
        ed.apply();
    }
    // Метод загрузки состояния
    public void loadState() {
        sPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        sort = sPref.getInt("SortMain", 0); //Сортировка
    }


}

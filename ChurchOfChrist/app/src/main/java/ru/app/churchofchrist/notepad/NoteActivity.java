package ru.app.churchofchrist.notepad;
//Блокнот разработан неизвестным специалистом из GitHub. Доработан trifonenko

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import ru.app.churchofchrist.R;

public class NoteActivity extends AppCompatActivity {

    final String LOG_TAG = "MYLOG";

    ConstraintLayout constr1;
    EditText editText1;
    EditText editText2;
    Spinner spinner1;

    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

    String action; // Создание или редактирование
    int id; // id нажатого пункта списка

    // Цвета
    String[] colorList = {"color0", "color1", "color2", "color3",
            "color4", "color5", "color6", "color7", "color8"};

    SharedPreferences sPref; // Сохранение
    int textSize; // Размер текста
    int colorTheme; // Цветовая тема
    int tableNumber; // Номер таблицы

    long backPressed; // Двойное нажатие


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dbHelper = MainActivity.appDBHelper;

        constr1 = findViewById(R.id.constr1);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        spinner1 = findViewById(R.id.spinner1);
        // Кастомный адаптер
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this, R.layout.item_color, colorList);
        spinner1.setAdapter(spinnerAdapter);

        action = getIntent().getStringExtra("Action"); // Создание или редактирование
        id = getIntent().getIntExtra("Id", 0); // id нажатого пункта списка
        tableNumber = getIntent().getIntExtra("TableNumber", 1); // Номер таблицы

        // Вывод содержимого
        if (action.equals("UPDATE")) {
            selectNote(); // Показать заметку
        }

        loadState(); // Загрузка SharedPreferences

        // Установка размера текста
        editText1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); // Чтобы размер совпадал

        if (textSize == 1) {
            editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        }
        else if (textSize == 2) {
            editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        }
        else if (textSize == 3) {
            editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        }
        else if (textSize == 0) {
            editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }

        // Цветная тема
        if (colorTheme == 1) {
            editText1.setTextColor(ContextCompat.getColor(this, R.color.white));
            editText2.setTextColor(ContextCompat.getColor(this, R.color.white));
            editText1.setBackgroundResource(R.color.gray);
            editText2.setBackgroundResource(R.color.gray);
            constr1.setBackgroundResource(R.color.gray_dark);
        }
        else if (colorTheme == 2) {
            editText1.setTextColor(ContextCompat.getColor(this, R.color.white));
            editText2.setTextColor(ContextCompat.getColor(this, R.color.white));
            editText1.setBackgroundResource(R.color.black_light);
            editText2.setBackgroundResource(R.color.black_light);
            constr1.setBackgroundResource(R.color.black);
        }
        else if (colorTheme == 3) {
            editText1.setTextColor(ContextCompat.getColor(this, R.color.green));
            editText2.setTextColor(ContextCompat.getColor(this, R.color.green));
            editText1.setBackgroundResource(R.color.black_light);
            editText2.setBackgroundResource(R.color.black_light);
            constr1.setBackgroundResource(R.color.black);
        }
        else if (colorTheme == 0) {
            editText1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryText));
            editText2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryText));
            editText1.setBackgroundResource(R.color.white);
            editText2.setBackgroundResource(R.color.white);
            constr1.setBackgroundResource(R.color.gray_light);
        }

    }


    // Добавить/Обновить заметку
    public void insertOrUpdateNote() {

        // Данные из полей ввода
        // Тема
        String theme = editText1.getText().toString();
        // Если пусто, передать 30 символов из заметки
        if (editText1.getText().toString().equals("")) {
            int l = editText2.getText().toString().length();
            if (l > 30) l = 30;
            char[] themeChar = new char[l];
            editText2.getText().toString().getChars(0, l, themeChar, 0);
            theme = new String(themeChar) + "...";
        }
        // Заметка
        String note = editText2.getText().toString();

        // Дата
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat myDate = new SimpleDateFormat("dd/MM/yyyy   HH:mm", Locale.ENGLISH);
        String date = myDate.format(calendar.getTime());

        // Цвет
        String color = "color0";
        switch (spinner1.getSelectedItemPosition()) {
            case 0: color = "color0"; break;
            case 1: color = "color1"; break;
            case 2: color = "color2"; break;
            case 3: color = "color3"; break;
            case 4: color = "color4"; break;
            case 5: color = "color5"; break;
            case 6: color = "color6"; break;
            case 7: color = "color7"; break;
            case 8: color = "color8"; break;
        }

        // Дата для сортировки
        long dateSort = System.currentTimeMillis();

        // Объект для данных
        ContentValues cv = new ContentValues();
        // Упаковка данных
        cv.put("theme", theme);
        cv.put("content_note", note);
        cv.put("date_time", date);
        cv.put("color", color);
        cv.put("date_sort", dateSort);

        // Подключение к БД
        db = dbHelper.getWritableDatabase();

        // Добавление/Обновление
        if (action.equals("INSERT")) {

            // Добавление данных
            db.insert("table1", null, cv);
            Log.d(LOG_TAG, "---------Add content_note---------");
        }
        else if (action.equals("UPDATE")) {

            // Обновление данных
            if (tableNumber == 1) {
                db.update("table1", cv, "_id = ?", new String[]{String.valueOf(id)});
            }
            else if (tableNumber == 2) {
                db.update("table2", cv, "_id = ?", new String[]{String.valueOf(id)});
            }
            Log.d(LOG_TAG, "---------Update content_note---------");
        }

        // Закрыть подключение к БД
        dbHelper.close();

        // Переход на Main
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    // Показать заметку
    public void selectNote() {

        // Подключение к БД
        db = dbHelper.getWritableDatabase();

        // Запрос данных по id
        if (tableNumber == 1) {
            cursor = db.query("table1", null, "_id = ?", new String[]{String.valueOf(id)}, null, null, null);
        }
        else if (tableNumber == 2) {
            cursor = db.query("table2", null, "_id = ?", new String[]{String.valueOf(id)}, null, null, null);
        }

        // Курсор в начало
        cursor.moveToFirst();
        // Получение содержимого полей
        String theme = cursor.getString(1); // Тема
        String note = cursor.getString(2); // Заметка
        String color = cursor.getString(4); // Цвет

        // Закрыть курсор
        if (cursor != null)
            cursor.close();

        // Закрыть подключение к БД
        dbHelper.close();

        editText1.setText(theme);
        editText2.setText(note);

        switch (color) {
            case "color0": spinner1.setSelection(0); break;
            case "color1": spinner1.setSelection(1); break;
            case "color2": spinner1.setSelection(2); break;
            case "color3": spinner1.setSelection(3); break;
            case "color4": spinner1.setSelection(4); break;
            case "color5": spinner1.setSelection(5); break;
            case "color6": spinner1.setSelection(6); break;
            case "color7": spinner1.setSelection(7); break;
            case "color8": spinner1.setSelection(8); break;
        }

    }


    // Удалить заметку
    public void deleteNote() {

        // Диалог:
        // Действительно удалить?
        new AlertDialog.Builder(NoteActivity.this)
                .setTitle(R.string.note_delete)
                .setMessage(R.string.delete_dialog)
                .setIcon(R.drawable.ic_alert_black_48dp)
                // Нет
                .setNegativeButton(R.string.r_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idDialog) {

                    }
                })
                // Да
                .setPositiveButton(R.string.r_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idDialog) {

                        // Подключение к БД
                        db = dbHelper.getWritableDatabase();

                        // Удаление данных
                        if (tableNumber == 1) {
                            db.delete("table1", "_id = ?", new String[]{String.valueOf(id)});
                        }
                        else if (tableNumber == 2) {
                            db.delete("table2", "_id = ?", new String[]{String.valueOf(id)});
                        }
                        Log.d(LOG_TAG, "---------Delete content_note---------");

                        // Закрыть подключение к БД
                        dbHelper.close();

                        // Переход на Main
                        Intent intent = new Intent(NoteActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }).create().show();
    }


    @Override
    protected void onPause () {
        saveState(); // Сохранение
        super.onPause();
    }

    @Override
    public void onBackPressed() {

        // Выход по двойному нажатию
        if (backPressed + 2000 > System.currentTimeMillis()) {
            // Переход на Main
            Intent intent = new Intent(NoteActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getBaseContext(), R.string.two_click, Toast.LENGTH_SHORT).show();
            backPressed = System.currentTimeMillis();
        }

    }


    // Меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Если апдейт, то показать меню с кнопкой удаления
        if (action.equals("UPDATE")) {
            getMenuInflater().inflate(R.menu.menu_update, menu);
        }
        else if (action.equals("INSERT")) {
            getMenuInflater().inflate(R.menu.menu_insert, menu);
        }
        return true;
    }
    // Пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // Удалить
        if (id == R.id.note_delete) {
            deleteNote();
        }
        // Шрифт
        else if (id == R.id.note_text_size) {

            if (textSize == 0) {
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                textSize++;
            }
            else if (textSize == 1) {
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                textSize++;
            }
            else if (textSize == 2) {
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                textSize++;
            }
            else if (textSize == 3) {
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                textSize = 0;
            }
        }
        // Цвета
        else if (id == R.id.note_color) {

            if (colorTheme == 0) {
                editText1.setTextColor(ContextCompat.getColor(this, R.color.white));
                editText2.setTextColor(ContextCompat.getColor(this, R.color.white));
                editText1.setBackgroundResource(R.color.gray);
                editText2.setBackgroundResource(R.color.gray);
                constr1.setBackgroundResource(R.color.gray_dark);
                colorTheme++;
            }
            else if (colorTheme == 1) {
                editText1.setTextColor(ContextCompat.getColor(this, R.color.white));
                editText2.setTextColor(ContextCompat.getColor(this, R.color.white));
                editText1.setBackgroundResource(R.color.black_light);
                editText2.setBackgroundResource(R.color.black_light);
                constr1.setBackgroundResource(R.color.black);
                colorTheme++;
            }
            else if (colorTheme == 2) {
                editText1.setTextColor(ContextCompat.getColor(this, R.color.green));
                editText2.setTextColor(ContextCompat.getColor(this, R.color.green));
                editText1.setBackgroundResource(R.color.black_light);
                editText2.setBackgroundResource(R.color.black_light);
                constr1.setBackgroundResource(R.color.black);
                colorTheme++;
            }
            else if (colorTheme == 3) {
                editText1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryText));
                editText2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryText));
                editText1.setBackgroundResource(R.color.white);
                editText2.setBackgroundResource(R.color.white);
                constr1.setBackgroundResource(R.color.gray_light);
                colorTheme = 0;
            }

        }

        // Save
        else if (id == R.id.note_save) {
            insertOrUpdateNote(); //Добавить/Обновить

        }
        return super.onOptionsItemSelected(item);
    }


    // Кастомный спиннер-адаптер
    private class SpinnerAdapter extends ArrayAdapter<String> {

        SpinnerAdapter(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        private View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.item_color, parent, false);

            LinearLayout linearLayout = row.findViewById(R.id.itemColor);

            switch (colorList[position]) {
                case "color0": linearLayout.setBackgroundResource(R.color.color0); break;
                case "color1": linearLayout.setBackgroundResource(R.color.color1); break;
                case "color2": linearLayout.setBackgroundResource(R.color.color2); break;
                case "color3": linearLayout.setBackgroundResource(R.color.color3); break;
                case "color4": linearLayout.setBackgroundResource(R.color.color4); break;
                case "color5": linearLayout.setBackgroundResource(R.color.color5); break;
                case "color6": linearLayout.setBackgroundResource(R.color.color6); break;
                case "color7": linearLayout.setBackgroundResource(R.color.color7); break;
                case "color8": linearLayout.setBackgroundResource(R.color.color8); break;
            }
            return row;
        }
    }


    // Метод сохранения состояния
    public void saveState() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("TextSize", textSize); // Размер текста
        ed.putInt("ColorTheme", colorTheme); // Цветная тема
        ed.apply();
    }
    // Метод загрузки состояния
    public void loadState() {
        sPref = getPreferences(MODE_PRIVATE);
        textSize = sPref.getInt("TextSize", 2); // Размер текста
        colorTheme = sPref.getInt("ColorTheme", 0); // Цветная тема
    }


}

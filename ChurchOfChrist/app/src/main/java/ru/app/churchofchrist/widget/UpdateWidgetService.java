package ru.app.churchofchrist.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.io.IOException;
import java.util.Random;

import ru.app.churchofchrist.DBHelper;
import ru.app.churchofchrist.R;

public class UpdateWidgetService extends Service {


    @Override
    public void onStart(Intent intent, int startId) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());
        int[] allWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
        for (int widgetId : allWidgetIds) {


        DBHelper dbHelper = new DBHelper(this, "lessons.db", 3);//10.04.2018 (версия в google 0)
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        final SQLiteDatabase database = dbHelper.getReadableDatabase();


        Cursor cursor = database.rawQuery("SELECT * FROM bible_verse_s", null);
        Random random = new Random();
        int randomNum = random.nextInt(cursor.getCount());
        cursor.moveToPosition(randomNum);







            RemoteViews remoteViews = new RemoteViews(this.getApplicationContext().getPackageName(), R.layout.widget_layout);

            // Установить текст
            remoteViews.setTextViewText(R.id.textView, String.valueOf(cursor.getString(0)));
            remoteViews.setTextViewText(R.id.textView11, String.valueOf(cursor.getString(1)));
            cursor.close();
            // Зарегистрировать onClickListener
            Intent clickIntent = new Intent(this.getApplicationContext(), MyWidgetProvider.class);

            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);


            remoteViews.setOnClickPendingIntent(R.id.imageView9, pendingIntent);


            appWidgetManager.updateAppWidget(widgetId, remoteViews);



        }
        stopSelf();

        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
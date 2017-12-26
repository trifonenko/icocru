package ru.app.churchofchrist.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.util.Random;

import ru.app.churchofchrist.R;

public class UpdateWidgetService extends Service {

    @Override
    public void onStart(Intent intent, int startId) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());

        int[] allWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
        for (int widgetId : allWidgetIds) {
            // Создание случайных данных
            int numVerse = 2;//Количество отрывков.
            String[] randomVerseArray = new String[numVerse];//Массив отрывков.
            randomVerseArray[0] = getResources().getString(R.string.excerpt_bt_01_16);
            randomVerseArray[1] = getResources().getString(R.string.excerpt_iov_26_07);

            String[] coordinatesVerseArray = new String[numVerse];//Массив координат отрывков.
            coordinatesVerseArray[0] = "Бытие 1:16";
            coordinatesVerseArray[1] = "Иов 26:7";


            final Random random = new Random();
            int randomNum = random.nextInt(numVerse);

            RemoteViews remoteViews = new RemoteViews(this.getApplicationContext().getPackageName(), R.layout.widget_layout);

            // Установить текст
            remoteViews.setTextViewText(R.id.textView, String.valueOf(randomVerseArray[randomNum]));
            remoteViews.setTextViewText(R.id.textView11, String.valueOf(coordinatesVerseArray[randomNum]));

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
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
            int numVerse = 138;//Количество отрывков.
            String[] randomVerseArray = new String[numVerse];//Массив отрывков.
            randomVerseArray[0] = getResources().getString(R.string.excerpt_bt_01_16);
            randomVerseArray[1] = getResources().getString(R.string.excerpt_iov_26_07);
            randomVerseArray[2] = getResources().getString(R.string.excerpt_iov_36_26_29);
            randomVerseArray[3] = getResources().getString(R.string.excerpt_ps_117_09);
            randomVerseArray[4] = getResources().getString(R.string.excerpt_ps_138_23_24);
            randomVerseArray[5] = getResources().getString(R.string.excerpt_prt_13_10);
            randomVerseArray[6] = getResources().getString(R.string.excerpt_prt_23_22_26);
            randomVerseArray[7] = getResources().getString(R.string.excerpt_is_046_03_04);
            randomVerseArray[8] = getResources().getString(R.string.excerpt_is_059_01_02);
            randomVerseArray[9] = getResources().getString(R.string.excerpt_is_066_02);
            randomVerseArray[10] = getResources().getString(R.string.excerpt_ier_29_11_13);
            randomVerseArray[11] = getResources().getString(R.string.excerpt_mf_05_27_28);
            randomVerseArray[12] = getResources().getString(R.string.excerpt_mf_06_33);
            randomVerseArray[13] = getResources().getString(R.string.excerpt_mf_07_15_16);
            randomVerseArray[14] = getResources().getString(R.string.excerpt_mf_09_35_38);
            randomVerseArray[15] = getResources().getString(R.string.excerpt_mf_10_37);
            randomVerseArray[16] = getResources().getString(R.string.excerpt_mf_16_18);
            randomVerseArray[17] = getResources().getString(R.string.excerpt_mf_22_37_38);
            randomVerseArray[18] = getResources().getString(R.string.excerpt_mf_26_39);
            randomVerseArray[19] = getResources().getString(R.string.excerpt_mf_28_18_20);
            randomVerseArray[20] = getResources().getString(R.string.excerpt_mk_01_35);
            randomVerseArray[21] = getResources().getString(R.string.excerpt_mk_07_20_21);
            randomVerseArray[22] = getResources().getString(R.string.excerpt_mk_12_28_30);
            randomVerseArray[23] = getResources().getString(R.string.excerpt_lk_05_15_16);
            randomVerseArray[24] = getResources().getString(R.string.excerpt_in_01_03);
            randomVerseArray[25] = getResources().getString(R.string.excerpt_in_03_16);
            randomVerseArray[26] = getResources().getString(R.string.excerpt_in_05_41_44);
            randomVerseArray[27] = getResources().getString(R.string.excerpt_in_06_56_57);
            randomVerseArray[28] = getResources().getString(R.string.excerpt_in_08_31_32);
            randomVerseArray[29] = getResources().getString(R.string.excerpt_in_08_44);
            randomVerseArray[30] = getResources().getString(R.string.excerpt_in_11_26);
            randomVerseArray[31] = getResources().getString(R.string.excerpt_in_13_34_35);
            randomVerseArray[32] = getResources().getString(R.string.excerpt_in_14_06_07);
            randomVerseArray[33] = getResources().getString(R.string.excerpt_in_14_23_24);
            randomVerseArray[34] = getResources().getString(R.string.excerpt_in_15_01_02);
            randomVerseArray[35] = getResources().getString(R.string.excerpt_in_15_05_06);
            randomVerseArray[36] = getResources().getString(R.string.excerpt_in_16_23_24);
            randomVerseArray[37] = getResources().getString(R.string.excerpt_deyn_02_22_24);
            randomVerseArray[38] = getResources().getString(R.string.excerpt_deyn_03_19_20);
            randomVerseArray[39] = getResources().getString(R.string.excerpt_deyn_04_12);
            randomVerseArray[40] = getResources().getString(R.string.excerpt_deyn_05_28_29);
            randomVerseArray[41] = getResources().getString(R.string.excerpt_deyn_17_10_12);
            randomVerseArray[42] = getResources().getString(R.string.excerpt_deyn_17_24_26);
            randomVerseArray[43] = getResources().getString(R.string.excerpt_deyn_17_30_31);
            randomVerseArray[44] = getResources().getString(R.string.excerpt_rim_01_19_20);
            randomVerseArray[45] = getResources().getString(R.string.excerpt_rim_03_23);
            randomVerseArray[46] = getResources().getString(R.string.excerpt_rim_05_06_08);
            randomVerseArray[47] = getResources().getString(R.string.excerpt_rim_06_03_04);
            randomVerseArray[48] = getResources().getString(R.string.excerpt_rim_06_23);
            randomVerseArray[49] = getResources().getString(R.string.excerpt_rim_08_01_02);
            randomVerseArray[50] = getResources().getString(R.string.excerpt_rim_10_09_10);
            randomVerseArray[51] = getResources().getString(R.string.excerpt_rim_10_17);
            randomVerseArray[52] = getResources().getString(R.string.excerpt_rim_12_10);
            randomVerseArray[53] = getResources().getString(R.string.excerpt_rim_14_11_12);
            randomVerseArray[54] = getResources().getString(R.string.excerpt_1kor_03_16_17);
            randomVerseArray[55] = getResources().getString(R.string.excerpt_1kor_04_06);
            randomVerseArray[56] = getResources().getString(R.string.excerpt_1kor_07_39);
            randomVerseArray[57] = getResources().getString(R.string.excerpt_1kor_12_12_13);
            randomVerseArray[58] = getResources().getString(R.string.excerpt_1kor_15_33);
            randomVerseArray[59] = getResources().getString(R.string.excerpt_1kor_16_01_02);
            randomVerseArray[60] = getResources().getString(R.string.excerpt_2kor_05_09_10);
            randomVerseArray[61] = getResources().getString(R.string.excerpt_2kor_05_14_15);
            randomVerseArray[62] = getResources().getString(R.string.excerpt_2kor_05_21);
            randomVerseArray[63] = getResources().getString(R.string.excerpt_gal_01_10);
            randomVerseArray[64] = getResources().getString(R.string.excerpt_gal_05_16_17);
            randomVerseArray[65] = getResources().getString(R.string.excerpt_gal_05_19_21);
            randomVerseArray[66] = getResources().getString(R.string.excerpt_gal_05_22_23);
            randomVerseArray[67] = getResources().getString(R.string.excerpt_ef_04_02_03);
            randomVerseArray[68] = getResources().getString(R.string.excerpt_ef_04_04);
            randomVerseArray[69] = getResources().getString(R.string.excerpt_ef_06_01_03);
            randomVerseArray[70] = getResources().getString(R.string.excerpt_ef_06_18);
            randomVerseArray[71] = getResources().getString(R.string.excerpt_flp_01_21);
            randomVerseArray[72] = getResources().getString(R.string.excerpt_flp_02_05_08);
            randomVerseArray[73] = getResources().getString(R.string.excerpt_flp_02_12_13);
            randomVerseArray[74] = getResources().getString(R.string.excerpt_kol_01_28_29);
            randomVerseArray[75] = getResources().getString(R.string.excerpt_1fes_02_17_19);
            randomVerseArray[76] = getResources().getString(R.string.excerpt_1fes_05_12);
            randomVerseArray[77] = getResources().getString(R.string.excerpt_1tim_02_03_04);
            randomVerseArray[78] = getResources().getString(R.string.excerpt_1tim_04_12);
            randomVerseArray[79] = getResources().getString(R.string.excerpt_1tim_04_16);
            randomVerseArray[80] = getResources().getString(R.string.excerpt_1tim_05_08);
            randomVerseArray[81] = getResources().getString(R.string.excerpt_2tim_02_22);
            randomVerseArray[82] = getResources().getString(R.string.excerpt_2tim_03_16_17);
            randomVerseArray[83] = getResources().getString(R.string.excerpt_flm_01_06);
            randomVerseArray[84] = getResources().getString(R.string.excerpt_evr_01_01_02);
            randomVerseArray[85] = getResources().getString(R.string.excerpt_evr_03_12_14);
            randomVerseArray[86] = getResources().getString(R.string.excerpt_evr_04_12_13);
            randomVerseArray[87] = getResources().getString(R.string.excerpt_evr_13_17);
            randomVerseArray[88] = getResources().getString(R.string.excerpt_iak_02_21_22);
            randomVerseArray[89] = getResources().getString(R.string.excerpt_iak_04_17);
            randomVerseArray[90] = getResources().getString(R.string.excerpt_iak_05_16);
            randomVerseArray[91] = getResources().getString(R.string.excerpt_1pet_02_02_03);
            randomVerseArray[92] = getResources().getString(R.string.excerpt_1pet_02_09_10);
            randomVerseArray[93] = getResources().getString(R.string.excerpt_1pet_02_17);
            randomVerseArray[94] = getResources().getString(R.string.excerpt_1pet_05_05_06);
            randomVerseArray[95] = getResources().getString(R.string.excerpt_2pet_01_20_21);
            randomVerseArray[96] = getResources().getString(R.string.excerpt_1in_01_07);
            randomVerseArray[97] = getResources().getString(R.string.excerpt_1in_03_07);
            randomVerseArray[98] = getResources().getString(R.string.excerpt_otkr_03_05);
            randomVerseArray[99] = getResources().getString(R.string.excerpt_otkr_21_08);
            randomVerseArray[100] = getResources().getString(R.string.excerpt_otkr_22_18_19);
            randomVerseArray[101] = getResources().getString(R.string.excerpt_nav_01_08);
            randomVerseArray[102] = getResources().getString(R.string.excerpt_is_001_18_20);
            randomVerseArray[103] = getResources().getString(R.string.excerpt_prt_02_01_05);
            randomVerseArray[104] = getResources().getString(R.string.excerpt_kol_04_02);
            randomVerseArray[105] = getResources().getString(R.string.excerpt_flp_04_08);
            randomVerseArray[106] = getResources().getString(R.string.excerpt_flp_04_13);
            randomVerseArray[107] = getResources().getString(R.string.excerpt_1fes_05_18);
            randomVerseArray[108] = getResources().getString(R.string.excerpt_in_14_15_17);
            randomVerseArray[109] = getResources().getString(R.string.excerpt_in_14_26);
            randomVerseArray[110] = getResources().getString(R.string.excerpt_in_15_26);
            randomVerseArray[111] = getResources().getString(R.string.excerpt_2tim_04_07_08);
            randomVerseArray[112] = getResources().getString(R.string.excerpt_lk_22_31_32);
            randomVerseArray[113] = getResources().getString(R.string.excerpt_ekk_04_10);
            randomVerseArray[114] = getResources().getString(R.string.excerpt_mk_10_45);
            randomVerseArray[115] = getResources().getString(R.string.excerpt_1in_02_15_17);
            randomVerseArray[116] = getResources().getString(R.string.excerpt_iak_01_02_04);
            randomVerseArray[117] = getResources().getString(R.string.excerpt_1pet_01_05_07);
            randomVerseArray[118] = getResources().getString(R.string.excerpt_is_053_03_04);
            randomVerseArray[119] = getResources().getString(R.string.excerpt_1pet_05_08);
            randomVerseArray[120] = getResources().getString(R.string.excerpt_1kor_15_58);
            randomVerseArray[121] = getResources().getString(R.string.excerpt_rim_12_18);
            randomVerseArray[122] = getResources().getString(R.string.excerpt_kol_03_12_14);
            randomVerseArray[123] = getResources().getString(R.string.excerpt_iak_04_10);
            randomVerseArray[124] = getResources().getString(R.string.excerpt_ef_04_31_32);
            randomVerseArray[125] = getResources().getString(R.string.excerpt_iak_01_19_20);
            randomVerseArray[126] = getResources().getString(R.string.excerpt_prt_17_14);
            randomVerseArray[127] = getResources().getString(R.string.excerpt_mf_18_15);
            randomVerseArray[128] = getResources().getString(R.string.excerpt_ef_04_15);
            randomVerseArray[129] = getResources().getString(R.string.excerpt_iak_01_12);
            randomVerseArray[130] = getResources().getString(R.string.excerpt_in_13_12_15);
            randomVerseArray[131] = getResources().getString(R.string.excerpt_1pet_04_10_11);
            randomVerseArray[132] = getResources().getString(R.string.excerpt_iak_01_17_18);
            randomVerseArray[133] = getResources().getString(R.string.excerpt_mf_04_18_20);
            randomVerseArray[134] = getResources().getString(R.string.excerpt_gal_06_07_08);
            randomVerseArray[135] = getResources().getString(R.string.excerpt_1kor_06_12);
            randomVerseArray[136] = getResources().getString(R.string.excerpt_mf_07_21_22);
            randomVerseArray[137] = getResources().getString(R.string.excerpt_kol_03_23_24);

            String[] coordinatesVerseArray = new String[numVerse];//Массив координат отрывков.
            coordinatesVerseArray[0] = "Бытие 1:16";
            coordinatesVerseArray[1] = "Иов 26:7";
            coordinatesVerseArray[2] = "Иов 36:26-26";
            coordinatesVerseArray[3] = "Псалом 117:9";
            coordinatesVerseArray[4] = "Псалом 138:23-24";
            coordinatesVerseArray[5] = "Притчи 13:10";
            coordinatesVerseArray[6] = "Притчи 23:22-26";
            coordinatesVerseArray[7] = "Исаия 46:3-4";
            coordinatesVerseArray[8] = "Исаия 59:1-2";
            coordinatesVerseArray[9] = "Исаия 66:2";
            coordinatesVerseArray[10] = "Иеремия 29:11-13";
            coordinatesVerseArray[11] = "От Матфея 5:27-28";
            coordinatesVerseArray[12] = "От Матфея 6:33";
            coordinatesVerseArray[13] = "От Матфея 7:15-16";
            coordinatesVerseArray[14] = "От Матфея 9:35-38";
            coordinatesVerseArray[15] = "От Матфея 10:37";
            coordinatesVerseArray[16] = "От Матфея 16:18";
            coordinatesVerseArray[17] = "От Матфея 22:37-38";
            coordinatesVerseArray[18] = "От Матфея 26:39";
            coordinatesVerseArray[19] = "От Матфея 28:18-20";
            coordinatesVerseArray[20] = "От Марка 1:35";
            coordinatesVerseArray[21] = "От Марка 7:20-21";
            coordinatesVerseArray[22] = "От Марка 12:28-30";
            coordinatesVerseArray[23] = "От Луки 5:15-16";
            coordinatesVerseArray[24] = "От Иоанна 1:3";
            coordinatesVerseArray[25] = "От Иоанна 3:16";
            coordinatesVerseArray[26] = "От Иоанна 5:41-44";
            coordinatesVerseArray[27] = "От Иоанна 6:56-57";
            coordinatesVerseArray[28] = "От Иоанна 8:31-32";
            coordinatesVerseArray[29] = "От Иоанна 8:44";
            coordinatesVerseArray[30] = "От Иоанна 11:26";
            coordinatesVerseArray[31] = "От Иоанна 13:34-35";
            coordinatesVerseArray[32] = "От Иоанна 14:6-7";
            coordinatesVerseArray[33] = "От Иоанна 14:23-24";
            coordinatesVerseArray[34] = "От Иоанна 15:1-2";
            coordinatesVerseArray[35] = "От Иоанна 15:5-6";
            coordinatesVerseArray[36] = "От Иоанна 16:23-24";
            coordinatesVerseArray[37] = "Деяния 2:22-24";
            coordinatesVerseArray[38] = "Деяния 3:19-20";
            coordinatesVerseArray[39] = "Деяния 4:12";
            coordinatesVerseArray[40] = "Деяния 5:28-29";
            coordinatesVerseArray[41] = "Деяния 17:10-12";
            coordinatesVerseArray[42] = "Деяния 17:24-26";
            coordinatesVerseArray[43] = "Деяния 17:30-31";
            coordinatesVerseArray[44] = "Римлянам 1:19-20";
            coordinatesVerseArray[45] = "Римлянам 3:23";
            coordinatesVerseArray[46] = "Римлянам 5:6-8";
            coordinatesVerseArray[47] = "Римлянам 6:3-4";
            coordinatesVerseArray[48] = "Римлянам 6:23";
            coordinatesVerseArray[49] = "Римлянам 8:1-2";
            coordinatesVerseArray[50] = "Римлянам 10:9-10";
            coordinatesVerseArray[51] = "Римлянам 10:17";
            coordinatesVerseArray[52] = "Римлянам 12:10";
            coordinatesVerseArray[53] = "Римлянам 14:11-12";
            coordinatesVerseArray[54] = "1 Коринфянам 3:16-17";
            coordinatesVerseArray[55] = "1 Коринфянам 4:6";
            coordinatesVerseArray[56] = "1 Коринфянам 7:39";
            coordinatesVerseArray[57] = "1 Коринфянам 12:12-13";
            coordinatesVerseArray[58] = "1 Коринфянам 15:33";
            coordinatesVerseArray[59] = "1 Коринфянам 16:1-2";
            coordinatesVerseArray[60] = "2 Коринфянам 5:9-10";
            coordinatesVerseArray[61] = "2 Коринфянам 5:14-15";
            coordinatesVerseArray[62] = "2 Коринфянам 5:21";
            coordinatesVerseArray[63] = "Галатам 1:10";
            coordinatesVerseArray[64] = "Галатам 5:16-17";
            coordinatesVerseArray[65] = "Галатам 5:19-21";
            coordinatesVerseArray[66] = "Галатам 5:22-23";
            coordinatesVerseArray[67] = "Эфесянам 4:2-3";
            coordinatesVerseArray[68] = "Эфесянам 4:4";
            coordinatesVerseArray[69] = "Эфесянам 6:1-3";
            coordinatesVerseArray[70] = "Эфесянам 6:18";
            coordinatesVerseArray[71] = "Филиппийцам 1:21";
            coordinatesVerseArray[72] = "Филиппийцам 2:5-8";
            coordinatesVerseArray[73] = "Филиппийцам 2:12-13";
            coordinatesVerseArray[74] = "Колоссянам 1:28-29";
            coordinatesVerseArray[75] = "1 Фессалоникийцам 2:17-19";
            coordinatesVerseArray[76] = "1 Фессалоникийцам 5:12";
            coordinatesVerseArray[77] = "1 Тимофею 2:3-4";
            coordinatesVerseArray[78] = "1 Тимофею 4:12";
            coordinatesVerseArray[79] = "1 Тимофею 4:16";
            coordinatesVerseArray[80] = "1 Тимофею 5:8";
            coordinatesVerseArray[81] = "2 Тимофею 2:22";
            coordinatesVerseArray[82] = "2 Тимофею 3:16-17";
            coordinatesVerseArray[83] = "Филимону 1:6";
            coordinatesVerseArray[84] = "Евреям 1:1-2";
            coordinatesVerseArray[85] = "Евреям 3:12-14";
            coordinatesVerseArray[86] = "Евреям 4:12-13";
            coordinatesVerseArray[87] = "Евреям 13:17";
            coordinatesVerseArray[88] = "Иакова 2:21-22";
            coordinatesVerseArray[89] = "Иакова 4:17";
            coordinatesVerseArray[90] = "Иакова 5:16";
            coordinatesVerseArray[91] = "1 Петра 2:2-3";
            coordinatesVerseArray[92] = "1 Петра 2:9-10";
            coordinatesVerseArray[93] = "1 Петра 2:17";
            coordinatesVerseArray[94] = "1 Петра 5:5-6";
            coordinatesVerseArray[95] = "2 Петра 1:20-21";
            coordinatesVerseArray[96] = "1 Иоанна 1:7";
            coordinatesVerseArray[97] = "1 Иоанна 3:7";
            coordinatesVerseArray[98] = "Откровение 3:5";
            coordinatesVerseArray[99] = "Откровение 21:8";
            coordinatesVerseArray[100] = "Откровение 22:18-19";
            coordinatesVerseArray[101] = "Иисус Навин 1:8";
            coordinatesVerseArray[102] = "Исаия 1:18-20";
            coordinatesVerseArray[103] = "Притчи 2:1-5";
            coordinatesVerseArray[104] = "Колоссянам 4:2";
            coordinatesVerseArray[105] = "Филиппийцам 4:8";
            coordinatesVerseArray[106] = "Филиппийцам 4:13";
            coordinatesVerseArray[107] = "1 Фессалоникийцам 5:18";
            coordinatesVerseArray[108] = "От Иоанна 14:15-17";
            coordinatesVerseArray[109] = "От Иоанна 14:26";
            coordinatesVerseArray[110] = "От Иоанна 15:26";
            coordinatesVerseArray[111] = "2 Тимофею 4:7-8";
            coordinatesVerseArray[112] = "От Луки 22:31-32";
            coordinatesVerseArray[113] = "Екклесиаст 4:10";
            coordinatesVerseArray[114] = "От Марка 10:45";
            coordinatesVerseArray[115] = "1 Иоанна 2:15-17";
            coordinatesVerseArray[116] = "Иакова 1:2-4";
            coordinatesVerseArray[117] = "1 Петра 1:5-7";
            coordinatesVerseArray[118] = "Исаия 53:3-4";
            coordinatesVerseArray[119] = "1 Петра 5:8";
            coordinatesVerseArray[120] = "1 Коринфянам 15:58";
            coordinatesVerseArray[121] = "Римлянам 12:18";
            coordinatesVerseArray[122] = "Колоссянам 3:12-14";
            coordinatesVerseArray[123] = "Иакова 4:10";
            coordinatesVerseArray[124] = "Эфесянам 4:31-32";
            coordinatesVerseArray[125] = "Иакова 1:19-20";
            coordinatesVerseArray[126] = "Притчи 17:14";
            coordinatesVerseArray[127] = "От Матфея 18:15";
            coordinatesVerseArray[128] = "Эфесянам 4:15";
            coordinatesVerseArray[129] = "Иакова 1:12";
            coordinatesVerseArray[130] = "От Иоанна 13:12-15";
            coordinatesVerseArray[131] = "1 Петра 4:10-11";
            coordinatesVerseArray[132] = "Иакова 1:17-18";
            coordinatesVerseArray[133] = "От Матфея 4:18-20";
            coordinatesVerseArray[134] = "Галатам 6:7-8";
            coordinatesVerseArray[135] = "1 Коринфянам 6:12";
            coordinatesVerseArray[136] = "От Матфея 7:21-22";
            coordinatesVerseArray[137] = "Колоссянам 3:23-24";


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
package ru.app.church_of_christ.christian_foundation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import ru.app.church_of_christ.R;

public class AnotherActivity extends Activity {

    @Override
    public void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();

        String caption = uri.getQueryParameter("caption");
        String text = uri.getQueryParameter("text");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(caption);
        switch (caption) {
            case "Иов 26:8":
                builder.setMessage(R.string.excerpt_iov_26_08);
                break;
            case "Иов 36:26-29":
                builder.setMessage(R.string.excerpt_iov_36_26_29);
                break;
            case "Екклесиаст 1:7":
                builder.setMessage(R.string.excerpt_ekk_01_07);
                break;
            case "Псалом 103:6-11":
                builder.setMessage(R.string.excerpt_ps_103_06_11);
                break;
            case "Бытие 1:1":
                builder.setMessage(R.string.excerpt_bt_01_01);
                break;
            case "Иов 26:7":
                builder.setMessage(R.string.excerpt_iov_26_07);
                break;
            case "Левит 15:1-2":
                builder.setMessage(R.string.excerpt_lev_15_01_02);
                break;
            case "Левит 15:31":
                builder.setMessage(R.string.excerpt_lev_15_31);
                break;
            case "Левит 13":
                builder.setMessage(R.string.excerpt_lev_13);
                break;
            case "Левит 14":
                builder.setMessage(R.string.excerpt_lev_14);
                break;
            case "Второзаконие 23":
                builder.setMessage(R.string.excerpt_vtor_23);
                break;
            case "Бытие 1:16":
                builder.setMessage(R.string.excerpt_bt_01_16);
                break;
            case "Евреям 1:1-2":
                builder.setMessage(R.string.excerpt_evr_01_01_02);
                break;
            case "2-е Петра 1:20-21":
                builder.setMessage(R.string.excerpt_2pet_01_20_21);
                break;
            case "1-е Коринфянам 4:6":
                builder.setMessage(R.string.excerpt_1kor_04_06);
                break;
            case "Откровения 22:18-19":
                builder.setMessage(R.string.excerpt_otkr_22_18_19);
                break;
            case "2-е Тимофею 3:16-17":
                builder.setMessage(R.string.excerpt_2tim_03_16_17);
                break;
            case "Евреям 4:12-13":
                builder.setMessage(R.string.excerpt_evr_04_12_13);
                break;
            case "1-е Тимофею 4:16":
                builder.setMessage(R.string.excerpt_1tim_04_16);
                break;
            case "Деяния 17:10-12":
                builder.setMessage(R.string.excerpt_deyn_17_10_12);
                break;
            case "Иакова 1:22-25":
                builder.setMessage(R.string.excerpt_iak_01_22_25);
                break;
            case "От Иоанна 8:31-32":
                builder.setMessage(R.string.excerpt_in_08_31_32);
                break;
            case "Деяния 17:24-26":
                builder.setMessage(R.string.excerpt_deyn_17_24_26);
                break;
            case "Бытие 1:1-2":
                builder.setMessage(R.string.excerpt_bt_01_01_02);
                break;
            case "От Иоанна 1:3":
                builder.setMessage(R.string.excerpt_in_01_03);
                break;
            case "Римлянам 1:19-20":
                builder.setMessage(R.string.excerpt_rim_01_19_20);
                break;
            case "Деяния 17:26-29":
                builder.setMessage(R.string.excerpt_deyn_17_26_29);
                break;
            case "Деяния 14:14-17":
                builder.setMessage(R.string.excerpt_deyn_14_14_17);
                break;
            case "От Матфея 6:25-34":
                builder.setMessage(R.string.excerpt_mf_06_25_34);
                break;
            case "Деяния 17:30-31":
                builder.setMessage(R.string.excerpt_deyn_17_30_31);
                break;
            case "Римлянам 2:5-11":
                builder.setMessage(R.string.excerpt_rim_02_05_11);
                break;
            case "Римлянам 14:11-12":
                builder.setMessage(R.string.excerpt_rim_14_11_12);
                break;
            case "От Иоанна 3:16":
                builder.setMessage(R.string.excerpt_in_03_16);
                break;
            case "От Иоанна 14:23-24":
                builder.setMessage(R.string.excerpt_in_14_23_24);
                break;
            case "Исайя 46:3-4":
                builder.setMessage(R.string.excerpt_is_046_03_04);
                break;
            case "От Луки 11:1-4":
                builder.setMessage(R.string.excerpt_lk_11_01_04);
                break;
            case "От Луки 11:9-13":
                builder.setMessage(R.string.excerpt_lk_11_09_13);
                break;
            case "Иеремия 29:11-13":
                builder.setMessage(R.string.excerpt_ier_29_11_13);
                break;
            case "От Луки 2:1-7":
                builder.setMessage(R.string.excerpt_lk_02_01_07);
                break;
            case "От Луки 3:1-2":
                builder.setMessage(R.string.excerpt_lk_03_01_02);
                break;
            case "Деяния 2:22-24":
                builder.setMessage(R.string.excerpt_deyn_02_22_24);
                break;
            case "От Иоанна 14:6-7":
                builder.setMessage(R.string.excerpt_in_14_06_07);
                break;
            case "1-е Тимофею 2:3-6":
                builder.setMessage(R.string.excerpt_1tim_02_03_06);
                break;
            case "Деяния 4:12":
                builder.setMessage(R.string.excerpt_deyn_04_12);
                break;
            case "От Иоанна 16:23-24":
                builder.setMessage(R.string.excerpt_in_16_23_24);
                break;
            case "От Иоанна 3:16-21":
                builder.setMessage(R.string.excerpt_in_03_16_21);
                break;
            case "1-е Коринфянам 15:1-8":
                builder.setMessage(R.string.excerpt_1kor_15_01_08);
                break;
            case "От Иоанна 11:26":
                builder.setMessage(R.string.excerpt_in_11_26);
                break;
            case "Римлянам 10:9-10":
                builder.setMessage(R.string.excerpt_rim_10_09_10);
                break;
            case "От Марка 15:33-39":
                builder.setMessage(R.string.excerpt_mk_15_33_39);
                break;
            case "1-е Петра 2:21-25":
                builder.setMessage(R.string.excerpt_1pet_02_21_25);
                break;
            case "Римлянам 5:6-8":
                builder.setMessage(R.string.excerpt_rim_05_06_08);
                break;
            case "2-е Коринфянам 5:14-15":
                builder.setMessage(R.string.excerpt_2kor_05_14_15);
                break;
            case "2-е Коринфянам 5:20-21":
                builder.setMessage(R.string.excerpt_2kor_05_20_21);
                break;
            case "Деяния 11:19-26":
                builder.setMessage(R.string.excerpt_deyn_11_19_26);
                break;
            case "От Марка 1:14-18":
                builder.setMessage(R.string.excerpt_mk_01_14_18);
                break;
            case "От Луки 9:23-26":
                builder.setMessage(R.string.excerpt_lk_09_23_26);
                break;
            case "От Матфея 26:39":
                builder.setMessage(R.string.excerpt_mf_26_39);
                break;
            case "1-е Петра 3:14-17":
                builder.setMessage(R.string.excerpt_1pet_03_14_17);
                break;
            case "От Луки 14:25-33":
                builder.setMessage(R.string.excerpt_lk_14_25_33);
                break;
            case "От Иоанна 13:34-35":
                builder.setMessage(R.string.excerpt_in_13_34_35);
                break;
            case "От Матфея 28:18-20":
                builder.setMessage(R.string.excerpt_mf_28_18_20);
                break;
            case "1-е Петра 2:9-10":
                builder.setMessage(R.string.excerpt_1pet_02_09_10);
                break;
            case "Исайя 59:1-2":
                builder.setMessage(R.string.excerpt_is_059_01_02);
                break;
            case "Римлянам 3:23":
                builder.setMessage(R.string.excerpt_rim_03_23);
                break;
            case "1-е Иоанна 1:5-10":
                builder.setMessage(R.string.excerpt_1in_01_05_10);
                break;
            case "Галатам 5:19-21":
                builder.setMessage(R.string.excerpt_gal_05_19_21);
                break;
            case "1-е Коринфянам 3:16-17":
                builder.setMessage(R.string.excerpt_1kor_03_16_17);
                break;
            case "От Матфея 5:27-28":
                builder.setMessage(R.string.excerpt_mf_05_27_28);
                break;
            case "Римлянам 1:28-32":
                builder.setMessage(R.string.excerpt_rim_01_28_32);
                break;
            case "Эфесянам 4:25-31":
                builder.setMessage(R.string.excerpt_ef_04_25_31);
                break;
            case "Откровения 21:8":
                builder.setMessage(R.string.excerpt_otkr_21_08);
                break;
            case "Иакова 4:17":
                builder.setMessage(R.string.excerpt_iak_04_17);
                break;
            case "Римлянам 6:23":
                builder.setMessage(R.string.excerpt_rim_06_23);
                break;
            case "От Иоанна 3:1-7":
                builder.setMessage(R.string.excerpt_in_03_01_07);
                break;
            case "Деяния 2:36-41":
                builder.setMessage(R.string.excerpt_deyn_02_36_41);
                break;
            case "Римлянам 6:1-4":
                builder.setMessage(R.string.excerpt_rim_06_01_04);
                break;
            case "Галатам 5:16-17":
                builder.setMessage(R.string.excerpt_gal_05_16_17);
                break;
            case "Галатам 5:23-25":
                builder.setMessage(R.string.excerpt_gal_05_23_25);
                break;
            case "1-е Фессалоникийцам 4:13-17":
                builder.setMessage(R.string.excerpt_1fes_04_13_17);
                break;
            case "1-е Коринфянам 15:19-26":
                builder.setMessage(R.string.excerpt_1kor_15_19_26);
                break;
            case "1-е Коринфянам 15:35-58":
                builder.setMessage(R.string.excerpt_1kor_15_35_58);
                break;
            case "От Матфея 16:18":
                builder.setMessage(R.string.excerpt_mf_16_18);
                break;
            case "Деяния 2:38-47":
                builder.setMessage(R.string.excerpt_deyn_02_38_47);
                break;
            case "Колоссянам 1:15-18":
                builder.setMessage(R.string.excerpt_kol_01_15_18);
                break;
            case "Римлянам 6:3-4":
                builder.setMessage(R.string.excerpt_rim_06_03_04);
                break;
            case "1-е Коринфянам 12:12-13":
                builder.setMessage(R.string.excerpt_1kor_12_12_13);
                break;
            case "Эфесянам 2:13-22":
                builder.setMessage(R.string.excerpt_ef_02_13_22);
                break;
            case "1-е Коринфянам 12:14-27":
                builder.setMessage(R.string.excerpt_1kor_12_14_27);
                break;
            case "Евреям 10:19-25":
                builder.setMessage(R.string.excerpt_evr_10_19_25);
                break;
            case "Евреям 3:12-14":
                builder.setMessage(R.string.excerpt_evr_03_12_14);
                break;
            case "1-е Коринфянам 11:23-26":
                builder.setMessage(R.string.excerpt_1kor_11_23_26);
                break;
            case "От Иоанна 6:56-57":
                builder.setMessage(R.string.excerpt_in_06_56_57);
                break;
            case "От Луки 5:15-16":
                builder.setMessage(R.string.excerpt_lk_05_15_16);
                break;
            case "От Марка 1:35":
                builder.setMessage(R.string.excerpt_mk_01_35);
                break;
            case "Евреям 10:23-25":
                builder.setMessage(R.string.excerpt_evr_10_23_25);
                break;
            case "Эфесянам 6:5-9":
                builder.setMessage(R.string.excerpt_ef_06_05_09);
                break;
            case "1-е Коринфянам 15:33":
                builder.setMessage(R.string.excerpt_1kor_15_33);
                break;
            case "1-е Тимофею 5:8":
                builder.setMessage(R.string.excerpt_1tim_05_08);
                break;
            case "1-е Коринфянам 7:39":
                builder.setMessage(R.string.excerpt_1kor_07_39);
                break;
            case "2-е Коринфянам 6:14-18":
                builder.setMessage(R.string.excerpt_2kor_06_14_18);
                break;
            case "Евреям 13:17":
                builder.setMessage(R.string.excerpt_evr_13_17);
                break;
            case "1-е Коринфянам 16:1-2":
                builder.setMessage(R.string.excerpt_1kor_16_01_02);
                break;
            case "1-е Коринфянам 5:2":
                builder.setMessage(R.string.excerpt_1kor_05_02);
                break;
            case "1-е Коринфянам 5:9-11":
                builder.setMessage(R.string.excerpt_1kor_05_09_11);
                break;
            case "Псалом 138:1-18":
                builder.setMessage(R.string.excerpt_ps_138_01_18);
                break;
            case "Псалом 138:23-24":
                builder.setMessage(R.string.excerpt_ps_138_23_24);
                break;
            case "От Иоанна 8:44":
                builder.setMessage(R.string.excerpt_in_08_44);
                break;
            case "От Марка 7:20-23":
                builder.setMessage(R.string.excerpt_mk_07_20_23);
                break;
            case "Откровение 21:8":
                builder.setMessage(R.string.excerpt_otkr_21_08);
                break;
            case "Иакова 5:16":
                builder.setMessage(R.string.excerpt_iak_05_16);
                break;
            case "Филиппийцам 2:5-8":
                builder.setMessage(R.string.excerpt_flp_02_05_08);
                break;
            case "Эфесянам 4:2-3":
                builder.setMessage(R.string.excerpt_ef_04_02_03);
                break;
            case "1-е Петра 5:5-6":
                builder.setMessage(R.string.excerpt_1pet_05_05_06);
                break;
            case "Исаия 66:2":
                builder.setMessage(R.string.excerpt_is_066_02);
                break;
            case "2-е Коринфянам 5:21":
                builder.setMessage(R.string.excerpt_2kor_05_21);
                break;
            case "1-е Иоанна 1:7":
                builder.setMessage(R.string.excerpt_1in_01_07);
                break;
            case "Псалом 101:8-10":
                builder.setMessage(R.string.excerpt_ps_101_08_10);
                break;
            case "Римлянам 8:1-2":
                builder.setMessage(R.string.excerpt_rim_08_01_02);
                break;
            case "1-е Коринфянам 15:9-11":
                builder.setMessage(R.string.excerpt_1kor_15_09_11);
                break;
            case "Филиппийцам 1:21":
                builder.setMessage(R.string.excerpt_flp_01_21);
                break;
            case "1-е Фессалоникийцам 4:3-8":
                builder.setMessage(R.string.excerpt_1fes_04_03_08);
                break;
            case "2-е Тимофею 2:22":
                builder.setMessage(R.string.excerpt_2tim_02_22);
                break;
            case "Эфесянам 5:3-5":
                builder.setMessage(R.string.excerpt_ef_05_03_05);
                break;
            case "Псалом 117:9":
                builder.setMessage(R.string.excerpt_ps_117_09);
                break;
            case "От Марка 12:28-30":
                builder.setMessage(R.string.excerpt_mk_12_28_30);
                break;
            case "Эфесянам 6:1-3":
                builder.setMessage(R.string.excerpt_ef_06_01_03);
                break;
            case "1-е Петра 2:17":
                builder.setMessage(R.string.excerpt_1pet_02_17);
                break;
            case "1-е Фессалоникийцам 5:12":
                builder.setMessage(R.string.excerpt_1fes_05_12);
                break;
            case "Римлянам 13:1-7":
                builder.setMessage(R.string.excerpt_rim_13_01_07);
                break;
            case "Римлянам 12:10":
                builder.setMessage(R.string.excerpt_rim_12_10);
                break;
            case "1-е Иоанна 3:7":
                builder.setMessage(R.string.excerpt_1in_03_07);
                break;
            case "Иакова 2:21-22":
                builder.setMessage(R.string.excerpt_iak_02_21_22);
                break;
            case "От Матфея 26:38-39":
                builder.setMessage(R.string.excerpt_mf_26_38_39);
                break;
            case "Деяния 5:28-29":
                builder.setMessage(R.string.excerpt_deyn_05_28_29);
                break;
            case "От Матфея 6:33":
                builder.setMessage(R.string.excerpt_mf_06_33);
                break;
            case "Филиппийцам 2:12-13":
                builder.setMessage(R.string.excerpt_flp_02_12_13);
                break;
            case "1-е Петра 2:2-3":
                builder.setMessage(R.string.excerpt_1pet_02_02_03);
                break;
            case "1-е Тимофею 4:12":
                builder.setMessage(R.string.excerpt_1tim_04_12);
                break;
            case "От Луки 15:11-24":
                builder.setMessage(R.string.excerpt_lk_15_11_24);
                break;
            case "От Иоанна 8:1-9":
                builder.setMessage(R.string.excerpt_in_08_01_09);
                break;
            case "Евреям 12:5-11":
                builder.setMessage(R.string.excerpt_evr_12_05_11);
                break;
            case "Иеремия 29:11":
                builder.setMessage(R.string.excerpt_ier_29_11);
                break;
            case "От Иоанна 5:41-44":
                builder.setMessage(R.string.excerpt_in_05_41_44);
                break;
            case "Галатам 1:10":
                builder.setMessage(R.string.excerpt_gal_01_10);
                break;
            case "От Марка 12:14":
                builder.setMessage(R.string.excerpt_mk_12_14);
                break;
            case "2-е Коринфянам 5:9-10":
                builder.setMessage(R.string.excerpt_2kor_05_09_10);
                break;
            case "Притчи 23:22-26":
                builder.setMessage(R.string.excerpt_prt_23_22_26);
                break;
            case "От Иоанна 19:25-27":
                builder.setMessage(R.string.excerpt_in_19_25_27);
                break;
            case "1-е Фессалоникийцам 5:12-13":
                builder.setMessage(R.string.excerpt_1fes_05_12_13);
                break;
            case "Эфесянам 4:29-5:1":
                builder.setMessage(R.string.excerpt_ef_04_29_05_01);
                break;
            case "Эфесянам 4:20-5:5":
                builder.setMessage(R.string.excerpt_ef_04_20_05_05);
                break;
            case "Галатам 5:22-23":
                builder.setMessage(R.string.excerpt_gal_05_22_23);
                break;
            case "От Иоанна 15:1-17":
                builder.setMessage(R.string.excerpt_in_15_01_17);
                break;
            case "От Иоанна 15:1-2":
                builder.setMessage(R.string.excerpt_in_15_01_02);
                break;
            case "От Иоанна 15:5-6":
                builder.setMessage(R.string.excerpt_in_15_05_06);
                break;
            case "Римлянам 10:17":
                builder.setMessage(R.string.excerpt_rim_10_17);
                break;
            case "1-е Тимофею 2:3-4":
                builder.setMessage(R.string.excerpt_1tim_02_03_04);
                break;
            case "Эфесянам 2:11-22":
                builder.setMessage(R.string.excerpt_ef_02_11_22);
                break;
            case "Эфесянам 4:1-16":
                builder.setMessage(R.string.excerpt_ef_04_01_16);
                break;
            case "От Матфея 7:15-16":
                builder.setMessage(R.string.excerpt_mf_07_15_16);
                break;
            case "1-е Тимофею 4:1-3":
                builder.setMessage(R.string.excerpt_1tim_04_01_03);
                break;
            case "Эфесянам 4:4":
                builder.setMessage(R.string.excerpt_ef_04_04);
                break;
            case "Римлянам 12:1-8":
                builder.setMessage(R.string.excerpt_rim_12_01_08);
                break;
            case "От Луки 13:1-5":
                builder.setMessage(R.string.excerpt_lk_13_01_05);
                break;
            case "Деяния 26:20-21":
                builder.setMessage(R.string.excerpt_deyn_26_20_21);
                break;
            case "2-е Петра 2:20-22":
                builder.setMessage(R.string.excerpt_2pet_02_20_22);
                break;
            case "От Марка 7:20-21":
                builder.setMessage(R.string.excerpt_mk_07_20_21);
                break;
            case "2-е Коринфянам 7:8-11":
                builder.setMessage(R.string.excerpt_2kor_07_08_11);
                break;
            case "Деяния 3:19-20":
                builder.setMessage(R.string.excerpt_deyn_03_19_20);
                break;
            case "Римлянам 1:18-32":
                builder.setMessage(R.string.excerpt_rim_01_18_32);
                break;
            case "1-е Коринфянам 6:9-11":
                builder.setMessage(R.string.excerpt_1kor_06_09_11);
                break;
            case "Эфесянам 4:17-5:6":
                builder.setMessage(R.string.excerpt_ef_04_17_05_06);
                break;
            case "Колоссянам 3:1-5":
                builder.setMessage(R.string.excerpt_kol_03_01_05);
                break;
            case "2-е Тимофею 3:1-5":
                builder.setMessage(R.string.excerpt_2tim_03_01_05);
                break;
            case "Откровение 2:1-5":
                builder.setMessage(R.string.excerpt_otkr_02_01_05);
                break;
            case "От Марка 4:1-20":
                builder.setMessage(R.string.excerpt_mk_04_01_20);
                break;
            case "Откровение 3:14-17":
                builder.setMessage(R.string.excerpt_otkr_03_14_17);
                break;
            case "Откровение 3:5":
                builder.setMessage(R.string.excerpt_otkr_03_05);
                break;
            case "Филимону 6":
                builder.setMessage(R.string.excerpt_flm_01_06);
                break;
            case "1-е Фессалоникийцам 2:17-19":
                builder.setMessage(R.string.excerpt_1fes_02_17_19);
                break;
            case "Притчи 13:10":
                builder.setMessage(R.string.excerpt_prt_13_10);
                break;
            case "Эфесянам 6:18":
                builder.setMessage(R.string.excerpt_ef_06_18);
                break;
            case "Колосянам 1:28-29":
                builder.setMessage(R.string.excerpt_kol_01_28_29);
                break;
            case "От Иоанна 4:4-10":
                builder.setMessage(R.string.excerpt_in_04_04_10);
                break;
            case "От Луки 19:5-10":
                builder.setMessage(R.string.excerpt_lk_19_05_10);
                break;
            case "От Матфея 9:35-38":
                builder.setMessage(R.string.excerpt_mf_09_35_38);
                break;
            case "От Матфея 22:37-38":
                builder.setMessage(R.string.excerpt_mf_22_37_38);
                break;
            case "От Марка 1:16-18":
                builder.setMessage(R.string.excerpt_mk_01_16_18);
                break;
            case "От Матфея 10:37":
                builder.setMessage(R.string.excerpt_mf_10_37);
                break;
            case "Псалом 8:3-5":
                builder.setMessage(R.string.excerpt_ps_08_03_05);
                break;
            case "Псалом 102:13-19":
                builder.setMessage(R.string.excerpt_ps_102_13_19);
                break;
            case "Исаия 1:18-20":
                builder.setMessage(R.string.excerpt_is_001_18_20);
                break;
            case "Притчи 2:1-5":
                builder.setMessage(R.string.excerpt_prt_02_01_05);
                break;
            case "Колоссянам 4:2":
                builder.setMessage(R.string.excerpt_kol_04_02);
                break;
            case "От Матфея 12:34":
                builder.setMessage(R.string.excerpt_mf_12_34);
                break;
            case "Филиппийцам 4:8":
                builder.setMessage(R.string.excerpt_flp_04_08);
                break;
            case "Филиппийцам 4:13":
                builder.setMessage(R.string.excerpt_flp_04_13);
                break;
            case "1-е Фессалоникийцам 5:18":
                builder.setMessage(R.string.excerpt_1fes_05_18);
                break;
            case "От Иоанна 14:15-17":
                builder.setMessage(R.string.excerpt_in_14_15_17);
                break;
            case "От Иоанна 14:26":
                builder.setMessage(R.string.excerpt_in_14_26);
                break;
            case "От Иоанна 15:26":
                builder.setMessage(R.string.excerpt_in_15_26);
                break;
            case "От Иоанна 16:5-15":
                builder.setMessage(R.string.excerpt_in_16_05_15);
                break;
            case "Римлянам 12:4-8":
                builder.setMessage(R.string.excerpt_rim_12_04_08);
                break;
            case "1-е Коринфянам 12:4-11":
                builder.setMessage(R.string.excerpt_1kor_12_04_11);
                break;
            case "2-е Тимофею 4:7-8":
                builder.setMessage(R.string.excerpt_2tim_04_07_08);
                break;
            case "От Луки 22:31-32":
                builder.setMessage(R.string.excerpt_lk_22_31_32);
                break;
            case "От Марка 9:24":
                builder.setMessage(R.string.excerpt_mk_09_24);
                break;
            case "Екклесиаст 4:10":
                builder.setMessage(R.string.excerpt_ekk_04_10);
                break;
            case "Евреям 3:12":
                builder.setMessage(R.string.excerpt_evr_03_12);
                break;
            case "От Иоанна 11:12":
                builder.setMessage(R.string.excerpt_in_11_12);
                break;
            case "От Марка 10:45":
                builder.setMessage(R.string.excerpt_mk_10_45);
                break;
            case "1-е Иоанна 2:15-17":
                builder.setMessage(R.string.excerpt_1in_02_15_17);
                break;
            case "2-е Коринфянам 6:14-7:1":
                builder.setMessage(R.string.excerpt_2kor_06_14_07_01);
                break;
            case "3-е Царств 11:1-6":
                builder.setMessage(R.string.excerpt_3ts_11_01_06);
                break;
            case "1-е Царств 16:17":
                builder.setMessage(R.string.excerpt_1ts_16_17);
                break;
            case "От Матфея 11:2-6":
                builder.setMessage(R.string.excerpt_mf_11_02_06);
                break;
            case "От Матфея 3:11-17":
                builder.setMessage(R.string.excerpt_mf_03_11_17);
                break;
            case "Бытие 3:1-7":
                builder.setMessage(R.string.excerpt_bt_03_01_07);
                break;
            case "Бытие 16:1-2,11-12":
                builder.setMessage(R.string.excerpt_bt_16_01_02_11_12);
                break;
            case "От Луки 4:1-13":
                builder.setMessage(R.string.excerpt_lk_04_01_13);
                break;
            case "Иакова 1:2-4":
                builder.setMessage(R.string.excerpt_iak_01_02_04);
                break;
            case "1-е Петра 1:5-7":
                builder.setMessage(R.string.excerpt_1pet_01_05_07);
                break;
            case "Исаия 53:3-4":
                builder.setMessage(R.string.excerpt_is_053_03_04);
                break;
            case "От Матфея 4:1-11":
                builder.setMessage(R.string.excerpt_mf_04_01_11);
                break;
            case "От Луки 22:39-46":
                builder.setMessage(R.string.excerpt_lk_22_39_46);
                break;
            case "1-е Коринфянам 12:24-27":
                builder.setMessage(R.string.excerpt_1kor_12_24_27);
                break;
            case "Филиппийцам 2:12":
                builder.setMessage(R.string.excerpt_flp_02_12);
                break;
            case "1-е Петра 5:8":
                builder.setMessage(R.string.excerpt_1pet_05_08);
                break;
            case "1-е Коринфянам 15:58":
                builder.setMessage(R.string.excerpt_1kor_15_58);
                break;
            case "1-е Петра 5:5-11":
                builder.setMessage(R.string.excerpt_1pet_05_05_11);
                break;
            case "Римлянам 12:18":
                builder.setMessage(R.string.excerpt_rim_12_18);
                break;
            case "Колоссянам 3:12-14":
                builder.setMessage(R.string.excerpt_kol_03_12_14);
                break;
            case "Иакова 4:10":
                builder.setMessage(R.string.excerpt_iak_04_10);
                break;
            case "Эфесянам 4:31-32":
                builder.setMessage(R.string.excerpt_ef_04_31_32);
                break;
            case "Иакова 1:19-20":
                builder.setMessage(R.string.excerpt_iak_01_19_20);
                break;
            case "Притчи 17:14":
                builder.setMessage(R.string.excerpt_prt_17_14);
                break;
            case "От Матфея 7:1-5":
                builder.setMessage(R.string.excerpt_mf_07_01_05);
                break;
            case "От Матфея 18:15":
                builder.setMessage(R.string.excerpt_mf_18_15);
                break;
            case "Эфесянам 4:15":
                builder.setMessage(R.string.excerpt_ef_04_15);
                break;
            case "От Матфея 18:16":
                builder.setMessage(R.string.excerpt_mf_18_16);
                break;
            case "Притчи 1:10-19":
                builder.setMessage(R.string.excerpt_prt_01_10_19);
                break;
            case "Псалом 72":
                builder.setMessage(R.string.excerpt_ps_72);
                break;
            case "Иакова 1:12":
                builder.setMessage(R.string.excerpt_iak_01_12);
                break;
            case "От Матфея 20:24-28":
                builder.setMessage(R.string.excerpt_mf_20_24_28);
                break;
            case "От Иоанна 13:12-15":
                builder.setMessage(R.string.excerpt_in_13_12_15);
                break;
            case "1-е Петра 4:10-11":
                builder.setMessage(R.string.excerpt_1pet_04_10_11);
                break;
            case "Иакова 1:17-18":
                builder.setMessage(R.string.excerpt_iak_01_17_18);
                break;
            case "От Матфея 4:18-20":
                builder.setMessage(R.string.excerpt_mf_04_18_20);
                break;
            case "Галатам 6:7-8":
                builder.setMessage(R.string.excerpt_gal_06_07_08);
                break;
            case "1-е Коринфянам 6:12":
                builder.setMessage(R.string.excerpt_1kor_06_12);
                break;
            case "От Матфея 21:28-32":
                builder.setMessage(R.string.excerpt_mf_21_28_32);
                break;
            case "От Матфея 7:21-22":
                builder.setMessage(R.string.excerpt_mf_07_21_22);
                break;
            case "Колосянам 3:23-24":
                builder.setMessage(R.string.excerpt_kol_03_23_24);
                break;
            case "1-е Царств 16:7":
                builder.setMessage(R.string.excerpt_1ts_16_17);
                break;
            case "От Матфея 11:12":
                builder.setMessage(R.string.excerpt_mf_11_12);
                break;


        }
        builder.setPositiveButton("OK", dioclOK);
        builder.setCancelable(false);
        builder.create().show();
    }

    private DialogInterface.OnClickListener dioclOK = new DialogInterface.OnClickListener() {

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            finish();
        }
    };

}

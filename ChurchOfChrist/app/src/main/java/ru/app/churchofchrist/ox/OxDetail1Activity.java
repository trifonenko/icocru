package ru.app.churchofchrist.ox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.xml.sax.XMLReader;

import ru.app.churchofchrist.R;

public class OxDetail1Activity extends AppCompatActivity {

    int temp = 14;
    public static final String APP_PREFERENCES = "mysettings";

    private TextView lessonContent;
    public static final String KEY1 = "key1";//Имя дополнительного значения, передаваемого в интенте.
    public static final String KEY2 = "key2";//Имя дополнительного значения, передаваемого в интенте.
    public static final String KEY3 = "key3";//Имя дополнительного значения, передаваемого в интенте.
    public static final String KEY4 = "key4";//Имя дополнительного значения, передаваемого в интенте.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_span);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        temp = sharedPref.getInt("temp", temp);

        Intent intent = getIntent();
        int position1 = intent.getIntExtra(KEY1, -1);
        int position2 = intent.getIntExtra(KEY2, -1);
        int position3 = intent.getIntExtra(KEY3, -1);
        int position4 = intent.getIntExtra(KEY4, -1);
        int pos = 0;
        if (position1 != -1) {
            pos = position1;
        } else if (position2 != -1) {
            pos = position2;
        } else if (position3 != -1) {
            pos = position3;
        } else if (position4 != -1) {
            pos = position4;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//Объект Toolbar.
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//Кнопка "back" на Toolbar, активируется установкой иконки.
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//Слушатель кнопки "back".
            @Override
            public void onClick(View v) {
                finish();//Закрываем текущую активность.
            }
        });

        lessonContent = (TextView) findViewById(R.id.tvContent);//Объект TextView, выводящий текст урока.
        //lessonContent.setLinksClickable(true);??????????????
        lessonContent.setMovementMethod(new LinkMovementMethod());//Способ навигации по элементу.

        //Выводим текст урока в TextView взависимости от его позиции в списке.
        switch (pos) {
            case 0:
                if (position1 == 0) {
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                    setLesson("basic_christ_001");
                }
                if (position2 == 0) {
                    setLesson("vost_christ_001");
                    getSupportActionBar().setTitle(Lesson.lessonReturn[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 0) {
                    setLesson("teens_christ_001");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 0) {
                    setLesson("yong_christ_001");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 1:
                if (position1 == 1) {
                    setLesson("basic_christ_002");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position2 == 1) {
                    setLesson("vost_christ_002");
                    getSupportActionBar().setTitle(Lesson.lessonReturn[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 1) {
                    setLesson("teens_christ_002");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 1) {
                    setLesson("yong_christ_002");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 2:
                if (position1 == 2) {
                    setLesson("basic_christ_003");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position2 == 2) {
                    setLesson("vost_christ_003");
                    getSupportActionBar().setTitle(Lesson.lessonReturn[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 2) {
                    setLesson("teens_christ_003");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 2) {
                    setLesson("yong_christ_003");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 3:
                if (position1 == 3) {
                    setLesson("basic_christ_004");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position2 == 3) {
                    setLesson("vost_christ_004");
                    getSupportActionBar().setTitle(Lesson.lessonReturn[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 3) {
                    setLesson("teens_christ_004");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 3) {
                    setLesson("yong_christ_004");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 4:
                if (position1 == 4) {
                    setLesson("basic_christ_005");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position2 == 4) {
                    setLesson("vost_christ_005");
                    getSupportActionBar().setTitle(Lesson.lessonReturn[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 4) {
                    setLesson("teens_christ_005");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 4) {
                    setLesson("yong_christ_005");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }break;
            case 5:
                if (position1 == 5) {
                    setLesson("basic_christ_006");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 5) {
                    setLesson("teens_christ_006");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 5) {
                    setLesson("yong_christ_006");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 6:
                if (position1 == 6) {
                    setLesson("basic_christ_007");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 6) {
                    setLesson("teens_christ_007");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 6) {
                    setLesson("yong_christ_007");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 7:
                if (position1 == 7) {
                    setLesson("basic_christ_008");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 7) {
                    setLesson("teens_christ_008");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 7) {
                    setLesson("yong_christ_008");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 8:
                if (position1 == 8) {
                    setLesson("basic_christ_009");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 8) {
                    setLesson("teens_christ_009");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 8) {
                    setLesson("yong_christ_009");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 9:
                if (position1 == 9) {
                    setLesson("basic_christ_010");
                    getSupportActionBar().setTitle(Lesson.lessonFirstPrinciples[pos].getName());//Заголовок Toolbar.
                }
                if (position3 == 9) {
                    setLesson("teens_christ_010");
                    getSupportActionBar().setTitle(Lesson.lessonCharacterJesus[pos].getName());//Заголовок Toolbar.
                }
                if (position4 == 9) {
                    setLesson("yong_christ_010");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 10:
                if (position4 == 10) {
                    setLesson("yong_christ_011");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 11:
                if (position4 == 11) {
                    setLesson("yong_christ_012");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 12:
                if (position4 == 12) {
                    setLesson("yong_christ_013");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 13:
                if (position4 == 13) {
                    setLesson("yong_christ_014");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 14:
                if (position4 == 14) {
                    setLesson("yong_christ_015");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 15:
                if (position4 == 15) {
                    setLesson("yong_christ_016");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 16:
                if (position4 == 16) {
                    setLesson("yong_christ_017");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 17:
                if (position4 == 17) {
                    setLesson("yong_christ_018");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 18:
                if (position4 == 18) {
                    setLesson("yong_christ_019");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 19:
                if (position4 == 19) {
                    setLesson("yong_christ_020");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 20:
                if (position4 == 20) {
                    setLesson("yong_christ_021");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 21:
                if (position4 == 21) {
                    setLesson("yong_christ_022");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
            case 22:
                if (position4 == 22) {
                    setLesson("yong_christ_023");
                    getSupportActionBar().setTitle(Lesson.LessonYoungStudents[pos].getName());//Заголовок Toolbar.
                }
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        lessonContent.setTextSize((float) temp);//Размер текста песни.

    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("temp", temp);
        editor.apply();
    }

    void setLesson(String strArticleResId) {
        int contentLessonResId = getResources().getIdentifier(strArticleResId, "string", getPackageName());
        String text = getString(contentLessonResId);
        Spanned spannedText = Html.fromHtml(text, htmlImageGetter, htmlTagHandler);
        Spannable reversedText = revertSpanned(spannedText);
        lessonContent.setText(reversedText);
    }

    final Spannable revertSpanned(Spanned stext) {
        Object[] spans = stext.getSpans(0, stext.length(), Object.class);
        Spannable ret = Spannable.Factory.getInstance().newSpannable(stext.toString());
        if (spans != null && spans.length > 0) {
            for (int i = spans.length - 1; i >= 0; --i) {
                ret.setSpan(spans[i], stext.getSpanStart(spans[i]), stext.getSpanEnd(spans[i]), stext.getSpanFlags(spans[i]));
            }
        }

        return ret;
    }

    Html.ImageGetter htmlImageGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            int resId = getResources().getIdentifier(source, "drawable", getPackageName());
            Drawable ret = OxDetail1Activity.this.getResources().getDrawable(resId);
            ret.setBounds(0, 0, ret.getIntrinsicWidth(), ret.getIntrinsicHeight());
            return ret;
        }
    };

    Html.TagHandler htmlTagHandler = new Html.TagHandler() {
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            Object span = null;
            if (tag.startsWith("article_")) span = new ArticleSpan(OxDetail1Activity.this, tag);
            else if ("title".equalsIgnoreCase(tag))
                span = new AppearanceSpan(0xffff2020, AppearanceSpan.NONE, 20, true, true, false, false);
            else if (tag.startsWith("color_")) span = new ParameterizedSpan(tag.substring(6));
            if (span != null) processSpan(opening, output, span);
        }
    };

    void processSpan(boolean opening, Editable output, Object span) {
        int len = output.length();
        if (opening) {
            output.setSpan(span, len, len, Spannable.SPAN_MARK_MARK);
        } else {
            Object[] objs = output.getSpans(0, len, span.getClass());
            int where = len;
            if (objs.length > 0) {
                for (int i = objs.length - 1; i >= 0; --i) {
                    if (output.getSpanFlags(objs[i]) == Spannable.SPAN_MARK_MARK) {
                        where = output.getSpanStart(objs[i]);
                        output.removeSpan(objs[i]);
                        break;
                    }
                }
            }

            if (where != len) {
                output.setSpan(span, where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_font_size, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.zamet_ox:
                Intent intent = new Intent(OxDetail1Activity.this, ru.app.churchofchrist.notepad.MainActivity.class);
                startActivity(intent);
                break;
        }
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog, null);
            builder.setView(view)
                    .setTitle("Размер шрифта")
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            final TextView text = (TextView) view.findViewById(R.id.textView);
            text.setText(String.valueOf(temp));
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
            seekBar.setProgress(temp - 10);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    lessonContent.setTextSize(progress + 10);
                    text.setText(String.valueOf(progress + 10));
                    temp = progress + 10;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        return super.onOptionsItemSelected(item);


        }
    }


package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.app.churchofchrist.R;

public class LessonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);

        Lesson lesson = getIntent().getParcelableExtra("lesson");

        Toolbar toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        toolbar.setTitle(lesson.getTitle());

        TextView lessonTextView = findViewById(R.id.idLessonTextView);

        String s = "hello<b>world</b>";

        lessonTextView.setText(Html.fromHtml("<br><font color=\"#007BB3\" align=\"center\"><b><big>Как Вы думаете, что есть Библия?</big></b></font><br><br>\n" +
                "        <blockquote>Слово <i>«библия»</i> происходит от греческого слова <i>«biblion»</i>, что означает <i>«книга»</i> или <i>«письмо»</i>.</blockquote>\n" +
                "        <b>Факты:</b><br>\n" +
                "        Библия - наиболее распространенная книга на протяжении всей истории человечества. По данным книги рекордов Гиннеса, изданной в 1988 году, за период с 1815 по 1975 год было напечатано 2,500,000,000 экземпляров Библии.<br><br>\n" +
                "        2. Сейчас Библию можно читать - частично или полностью - более чем на 2100 языках мира. То есть Библия доступна 98% населения нашей планеты.<br><br>\n" +
                "        3. Ни одна другая книга в истории не становилась объектом такого жестокого преследования, и даже ненависти. Со времен средневековья и вплоть до XX века Библию сжигали на кострах. И даже в наше время зачтение и распространение Библии людей штрафовали и сажали в тюрьму, а в прошлые века - часто пытали и казнили.<br><br>\n" +
                "        4. В написании различных книг Библии участвовало 55 мужчин, среди которых были цари, пастухи, рыбаки, государственные служащие, священники, по меньшей мере, один полководец и один врач. Но все эти люди утверждали, что записывают не свои мысли, а мысли Бога.<br><br>\n" +
                "        5. Библия дает ответы на такие вопросы, на которые может ответить только Бог.<br><br>\n" +
                "        6. Библия состоит из 66 книг, в них содержаться законы, пророчества, исторические факты, стихи, советы и многое другое. Первые 39 книг написали верные израильтяне преимущественно на древнееврейском языке за сотни лет до Христа. Эта часть называется Ветхий Завет. Остальные 27 книг писали христиане на греческом языке, и называется вторая часть - Новый Завет. Эти 66 книг написаны приблизительно в течение 1 600 лет.<br><br>\n" +
                "        7. С точки зрения современной науки, Библии не устарела.<br><br>\n" +
                "        • Круговорот воды в природе учёные открыли только в 19 веке:<br>\n" +
                "        <a href='activity-run://AnotherActivityHost?caption=Иов%2026:8&text= " + s +" '><b>Иов 26:8</b></a>,\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Иов%2036:26-29\"><b>Иов 36:26-29</b></a>,\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Екклесиаст%201:7\"><b>Екклесиаст 1:7</b></a>,\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Псалом%20103:6-11\"><b>Псалом 103:6-11</b></a><br><br>\n" +
                "        • Вселенная имеет начало. Астрофизики обосновали это в 20 веке<br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Бытие%201:1\"><b>Бытие 1:1</b></a><br><br>\n" +
                "        • Земля покоится в пространстве <br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Иов%2026:7\"><b>Иов 26:7</b></a><br><br>\n" +
                "        • Луи Пастер открыл существование микробов в 1884 году\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Левит%2015:1-2\"><b>Левит 15:1-2</b></a>,\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Левит%2015:31\"><b>Левит 15:31</b></a><br><br>.\n" +
                "        Карантин\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Левит%2013\"><b>Левит 13</b></a>,\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Левит%2014\"><b>Левит 14</b></a>,\n" +
                "        утилизация отходов\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Второзаконие%2023\"><b>Второзаконие 23</b></a>, в средние века половина населения Европы умерло от эпидемий из-за несоблюдения этих норм.<br><br>\n" +
                "        • Люди научились определять величину светил около 200 лет назад. Солнце и луна имеют разную величину<br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Бытие%201:16\"><b>Бытие 1:16</b></a><br><br>\n" +
                "        • Современная археология подтверждает Библейские события.<br>\n" +
                "        <br><font color=\"#007BB3\" align=\"center\"><b><big>Откуда взялась Библия? (Ее смысл)</big></b></font><br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Евреям%201:1-2\"><b>Евреям 1:1-2</b></a><br>\n" +
                "        <blockquote><b>Библия</b> - это записанное Слово Бога, Его послание людям. Через пророков - Ветхий завет, через Иисуса Христа - Новый Завет. <br>\n" +
                "        Слово <b>«завет»</b> означает <b>«договор»</b>, соглашение между двумя сторонами».</blockquote>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=2-е%20Петра%201:20-21\"><b>2-е Петра 1:20-21</b></a><br>\n" +
                "        • Бог использовал определенных людей, чтобы записать Библию.<br>\n" +
                "        • Библия содержит мысли Бога, а не людей. (Например, люди записывают, что-либо при помощи авторучки. Бог - при помощи пророков.)<br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=1-е%20Коринфянам%204:6\"><b>1-е Коринфянам 4:6</b></a><br>\n" +
                "        • Библия - это единственное Слово Бога.<br>\n" +
                "        • Она закончена и совершенна.<br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Откровения%2022:18-19\"><b>Откровения 22:18-19</b></a><br>\n" +
                "        <br><font color=\"#007BB3\" align=\"center\"><b><big>Зачем она нам? (Ее назначение)</big></b></font><br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=2-е%20Тимофею%203:16-17\"><b>2-е Тимофею 3:16-17</b></a><br>\n" +
                "        • Чтобы мы могли познать истину, исправиться и знать, что от нас требуется для того, чтобы исполнить волю Бога.<br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Евреям%204:12-13\"><b>Евреям 4:12-13</b></a><br>\n" +
                "        • Чтобы отделить праведные чувства и помыслы от неправедных.<br>\n" +
                "        • Библия причиняет нам боль, удаляя грех, как хирург причиняет боль, скальпелем удаляя раковую опухоль.<br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=1-е%20Тимофею%204:16\"><b>1-е Тимофею 4:16</b></a><br>\n" +
                "        • Чтобы спастись и помочь спастись другим.<br>\n" +
                "        <br><font color=\"#007BB3\" align=\"center\"><b><big>Что нам с ней делать? (Ее применение)</big></b></font><br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Деяния%2017:10-12\"><b>Деяния 17:10-12</b></a><br>\n" +
                "        • <i>Пример для подражания</i>: приняли всем сердцем и изучали Писание каждый день.<br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=Иакова%201:22-25\"><b>Иакова 1:22-25</b></a><br>\n" +
                "        • Изучая Библию, сначала нужно определить, о чем говорит отрывок, а затем - как его практически применить в своей жизни.<br><br>\n" +
                "        <a href=\"activity-run://AnotherActivityHost?caption=От%20Иоанна%208:31-32\"><b>От Иоанна 8:31-32</b></a><br>\n" +
                "        • Не только верить, но и следовать учению Христа.<br><br>\n" +
                "        <b>Начни изучать Библию каждый день!</b>"));

        lessonTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
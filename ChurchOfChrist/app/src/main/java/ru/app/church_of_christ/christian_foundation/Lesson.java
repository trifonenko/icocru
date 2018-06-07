package ru.app.church_of_christ.christian_foundation;

import ru.app.church_of_christ.R;

class Lesson {
    private String name;
    private int textResId;

    private Lesson(String name, int textResId) {
        this.name = name;
        this.textResId = textResId;
    }

    static final Lesson[] lessonFirstPrinciples = {
            new Lesson("Библия - Слово Бога", R.string.basic_christ_001),
            new Lesson("Бог - Отец", R.string.basic_christ_002),
            new Lesson("Иисус", R.string.basic_christ_002),
            new Lesson("Крест Христа", R.string.basic_christ_002),
            new Lesson("Что значит быть учеником", R.string.basic_christ_002),
            new Lesson("Свет и тьма", R.string.basic_christ_002),
            new Lesson("Спасение и Святой Дух", R.string.basic_christ_002),
            new Lesson("Церковь", R.string.basic_christ_002),
            new Lesson("Иисус - Господь", R.string.basic_christ_002),
            new Lesson("Описание смерти Христа", R.string.basic_christ_002)
    };

    static final Lesson[] lessonReturn = {
            new Lesson("Пребудьте во Мне", R.string.vost_christ_001),
            new Lesson("Единство", R.string.vost_christ_002),
            new Lesson("Покаяние", R.string.vost_christ_003),
            new Lesson("Вспомни свою первую любовь", R.string.vost_christ_004),
            new Lesson("Отношения", R.string.vost_christ_005)
    };

    static final Lesson[] lessonCharacterJesus = {
            new Lesson("Честность", R.string.teens_christ_001),
            new Lesson("Скромность", R.string.teens_christ_002),
            new Lesson("Милость", R.string.teens_christ_003),
            new Lesson("Чистота", R.string.teens_christ_004),
            new Lesson("Уважение", R.string.teens_christ_005),
            new Lesson("Праведность", R.string.teens_christ_006),
            new Lesson("Личное стремление к Богу", R.string.teens_christ_007),
            new Lesson("Каков твой Отец", R.string.teens_christ_008),
            new Lesson("Кому ты стремишся угодить", R.string.teens_christ_009),
            new Lesson("Отношения в семье", R.string.teens_christ_010)
    };

    static final Lesson[] LessonYoungStudents = {
            new Lesson("Строить отношения с Богом", R.string.yong_christ_001),
            new Lesson("Благодарность - часть 1", R.string.yong_christ_002),
            new Lesson("Благодарность - часть 2", R.string.yong_christ_003),
            new Lesson("Святой Дух - учение Иисуса", R.string.yong_christ_004),
            new Lesson("Святой Дух - дары Святого Духа", R.string.yong_christ_005),
            new Lesson("Духовный марафон - часть 1", R.string.yong_christ_006),
            new Lesson("Духовный марафон - часть 2", R.string.yong_christ_007),
            new Lesson("Романтические отношения - часть 1", R.string.yong_christ_008),
            new Lesson("Романтические отношения - часть 2", R.string.yong_christ_009),
            new Lesson("Сомнения - часть 1", R.string.yong_christ_010),
            new Lesson("Сомнения - часть 2", R.string.yong_christ_011),
            new Lesson("Как проходить испытания - часть 1", R.string.yong_christ_012),
            new Lesson("Как проходить испытания - часть 2", R.string.yong_christ_013),
            new Lesson("Лев никогда не спит - часть 1", R.string.yong_christ_014),
            new Lesson("Лев никогда не спит - часть 2", R.string.yong_christ_015),
            new Lesson("Как решать конфликтные ситуации и не попадать в них - часть 1", R.string.yong_christ_016),
            new Lesson("Как решать конфликтные ситуации и не попадать в них - часть 2", R.string.yong_christ_017),
            new Lesson("Давление сверстников - часть 1", R.string.yong_christ_018),
            new Lesson("Давление сверстников - часть 2", R.string.yong_christ_019),
            new Lesson("Почему важно служить другим (часть 1)", R.string.yong_christ_020),
            new Lesson("Как понять какой у меня дар (часть 2)", R.string.yong_christ_021),
            new Lesson("Социальные сети", R.string.yong_christ_022),
            new Lesson("Слова и дела", R.string.yong_christ_023),
    };

    public String getName() {
        return name;
    }

    int getTextResId() {
        return textResId;
    }
}

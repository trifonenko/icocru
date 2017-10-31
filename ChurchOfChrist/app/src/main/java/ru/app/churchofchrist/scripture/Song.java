package ru.app.churchofchrist.scripture;

import ru.app.churchofchrist.R;

/**
 * Шаблон для объектов Song.
 */
class Song {
    private String name;//Имя песни.
    private int textResId;//Текст песни.
    private int chordsResId;//Аккорды.
    private String linkAudio;//Ссылка на аудио;
    private int linkVideo;//Ссылка на видео;
    private static Song[] arraySongs = {
            new Song("Библия. Изучение и исполнение", R.string.nrp_nav_01_08, R.string.sin_nav_01_08),
            new Song("Библия. Практика в жизни", R.string.excerpt_iak_01_22_25, R.string.excerpt_iak_01_22_25),
            new Song("Библия. Единственное Слово Бога", R.string.excerpt_1kor_04_06, R.string.excerpt_1kor_04_06),

    };

    private Song(String name, int textResId, int chordsResId) {
        this.name = name;
        this.textResId = textResId;
        this.chordsResId = chordsResId;
    }

    //Возвращает список имен песен.
    static String[] getArrayListNameSongs() {
        String[] arrayListNameSongs = new String[arraySongs.length];
        for (int i = 0; i < arrayListNameSongs.length; i++) {
            arrayListNameSongs[i] = arraySongs[i].getName();
        }
        return arrayListNameSongs;
    }

    public String getName() {
        return name;
    }

    public int getText() {
        return textResId;
    }

    static Song[] getArraySongs() {
        return arraySongs;
    }

    int getChordsResId() {
        return chordsResId;
    }

}

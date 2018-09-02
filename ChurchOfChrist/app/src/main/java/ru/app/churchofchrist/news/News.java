package ru.app.churchofchrist.news;

import android.net.Uri;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс представляет объект - Новость.<br />
 * Свойства класса:
 * <ul>
 * <li>{@code title} - заголовок
 * <li>{@code imageUri} - ссылка на изображение
 * </ul>
 */
@Setter
@Getter
class News {
    private String title;
    private Uri imageUri;
}
package ru.app.churchofchrist.news;

import android.net.Uri;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс представляет объект - Новость.<br />
 * Свойства класса:
 * <ul>
 * <li>{@code title} - заголовок
 * <li>{@code description} - описание
 * <li>{@code imageUri} - ссылка на изображение
 * <li>{@code datePublication} - дата публикации
 * </ul>
 */
@Setter
@Getter
class News {
    private String title;
    private String description;
    private Uri imageUri;
    private String datePublication;
}
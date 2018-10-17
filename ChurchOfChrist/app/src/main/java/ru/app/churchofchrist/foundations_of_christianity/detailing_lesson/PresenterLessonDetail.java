package ru.app.churchofchrist.foundations_of_christianity.detailing_lesson;

import android.content.Context;

import ru.app.churchofchrist.foundations_of_christianity.ModelImpl;

public class PresenterLessonDetail implements IContract.IPresenterLessonDetail {

    private IContract.IModelLessonDetail model;

    PresenterLessonDetail(Context context) {
        model = new ModelImpl(context);
    }

    public String getLessonText(String titleLesson) {
        return model.loadLessonText(titleLesson);
    }
}
package ru.app.churchofchrist.foundations_of_christianity.lessons_list;

import android.content.Context;

import java.util.List;

import ru.app.churchofchrist.foundations_of_christianity.Lesson;
import ru.app.churchofchrist.foundations_of_christianity.ModelImpl;

public class PresenterImpl implements IContract.IPresenter {

    private IContract.IView mIView;
    private IContract.IModel mIModel;

    public PresenterImpl(Context context, IContract.IView iView) {
        this.mIView = iView;
        mIModel = new ModelImpl(context);
    }

    @Override
    public List<String> getTopics() {
        return mIModel.loadTopicsLessons();
    }

    @Override
    public List<String> loadListTitles(String topicLessons) {
        return mIModel.titlesLessons(topicLessons);
    }
}
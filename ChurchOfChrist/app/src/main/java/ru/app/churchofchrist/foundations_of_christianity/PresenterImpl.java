package ru.app.churchofchrist.foundations_of_christianity;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;

class PresenterImpl implements IContract.IPresenter {

    private IContract.IView mIView;
    private IContract.IModel mIModel;

    PresenterImpl(Context context, IContract.IView iView) {
        this.mIView = iView;
        mIModel = new ModelImpl(context);
    }

    @Override
    public void onTabSelected(CharSequence contentDescription) {

        List<String> titlesLessons = Observable.fromIterable(mIModel.getListLessons((String) contentDescription))
                                               .map(Lesson::getTitle)
                                               .toList()
                                               .blockingGet();
        mIView.showListLessons(titlesLessons);
    }
}
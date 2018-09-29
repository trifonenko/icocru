package ru.app.churchofchrist.foundations_of_christianity;

import android.content.Context;

import java.util.List;

class PresenterImpl implements IContract.IPresenter {

    private IContract.IView mIView;
    private IContract.IModel mIModel;

    PresenterImpl(Context context, IContract.IView iView) {
        this.mIView = iView;
        mIModel = new ModelImpl(context);
    }

    @Override
    public List<Lesson> getListLessons(String nameTable) {
        return mIModel.getListLessons(nameTable);
    }
}
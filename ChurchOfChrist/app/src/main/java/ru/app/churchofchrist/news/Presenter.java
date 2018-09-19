package ru.app.churchofchrist.news;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

class Presenter implements IContract.IPresenter {
    private IContract.IView mIView;
    private IContract.IModel mIModel;


    Presenter(IContract.IView IView) {
        this.mIView = IView;
        this.mIModel = new Model();

    }

    @Override
    public void loadNews() {
        mIModel.loadNews()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new DisposableSingleObserver<List<News>>() {
                   @Override
                   public void onSuccess(List<News> aNews) {
                       NewsSingleton newsSingleton = NewsSingleton.getInstance();
                       newsSingleton.setNewsList(aNews);
                       mIView.loadNewsList(aNews);
                   }

                   @Override
                   public void onError(Throwable e) {
                   }
               });
    }


}

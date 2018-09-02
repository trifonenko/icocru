package ru.app.churchofchrist.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.app.churchofchrist.R;

public class NewsFragment extends Fragment implements IContract.IView {
    private RecyclerView recyclerView;
    private ProgressBar mProgressBar;
    private TextView mLabelProgressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        IContract.IPresenter presenter = new Presenter(this);
        presenter.loadNews();

        mProgressBar = view.findViewById(R.id.progressBar);
        mLabelProgressBar = view.findViewById(R.id.labelProgressBar);

        recyclerView = view.findViewById(R.id.idRecyclerViewNews);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void loadNewsList(List<News> newsList) {
        NewsRecyclerViewAdapter adapter = new NewsRecyclerViewAdapter(newsList);
        recyclerView.setAdapter(adapter);
        dismiss();
    }

    private void dismiss() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mLabelProgressBar.setVisibility(View.INVISIBLE);
    }
}
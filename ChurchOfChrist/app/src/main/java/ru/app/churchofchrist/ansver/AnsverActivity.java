package ru.app.churchofchrist.ansver;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import ru.app.churchofchrist.R;

public class AnsverActivity extends AppCompatActivity implements AnsverListFragment.AnsverListListener {

    private View fragmentContainer;
    private List<Ansver> mAnsver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansver);

        AnsverLab mAnsverLab = AnsverLab.getInstance(this);
        mAnsver = mAnsverLab.getAnsver();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            if (savedInstanceState == null) {
                onItemClicked("Беда приходит к нам");
            }
        }
    }

    @Override
    public void onItemClicked(CharSequence ansverName) {
        if (fragmentContainer != null) {
            AnsverDetailFragment ansverDetailFragment = new AnsverDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ansverDetailFragment.setAnsverId(ansverName);
            ft.replace(R.id.fragment_container, ansverDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, AnsverDetailActivity.class);
            intent.putExtra(AnsverDetailActivity.EXTRA_WORKOUT_ID, ansverName);
            startActivity(intent);
        }
    }
}

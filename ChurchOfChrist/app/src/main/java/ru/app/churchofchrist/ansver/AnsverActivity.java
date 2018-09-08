package ru.app.churchofchrist.ansver;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

        Toolbar toolbar = findViewById(R.id.idToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            if (savedInstanceState == null) {
                onItemClicked(1);
            }
        }
    }

    @Override
    public void onItemClicked(int ansverId) {
        if (fragmentContainer != null) {
            AnsverDetailFragment ansverDetailFragment = new AnsverDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ansverDetailFragment.setAnsverId(ansverId);
            ft.replace(R.id.fragment_container, ansverDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, AnsverDetailActivity.class);
            intent.putExtra(AnsverDetailActivity.EXTRA_WORKOUT_ID, ansverId);
            startActivity(intent);
        }
    }
}

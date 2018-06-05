package ru.app.church_of_christ.ansver;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import com.facebook.drawee.backends.pipeline.Fresco;

import ru.app.church_of_christ.R;

public class AnsverDetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_ansver_text);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ScrollView sv = (ScrollView) findViewById(R.id.scroll);

        Handler h = new Handler();

        h.postDelayed(new Runnable() {

            @Override
            public void run() {
                sv.scrollTo(0, 0);
            }
        }, 250); // 250 ms delay


        AnsverDetailFragment workoutDetailFragment = (AnsverDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        workoutDetailFragment.setAnsverId(workoutId);


    }
}

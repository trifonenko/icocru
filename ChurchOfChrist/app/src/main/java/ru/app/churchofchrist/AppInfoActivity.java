package ru.app.churchofchrist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.kobakei.ratethisapp.RateThisApp;

public class AppInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        // Установка пользовательских критериев (необязательно)
        RateThisApp.init(new RateThisApp.Config(3, 5));
        // Отслеживать время запуска и интервал от установки
        RateThisApp.onCreate(this);
        // Если условие выполнено, будет показано диалоговое окно «Оценить это приложение»
        RateThisApp.showRateDialogIfNeeded(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("О приложении");
        ///
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

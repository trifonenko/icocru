package ru.app.churchofchrist.ansver;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import ru.app.churchofchrist.R;

/**
 * Фрагмент, для отображения детализации песен.
 */
public class AnsverDetailFragment extends Fragment {

    private int ansverId;//Идентификатор песни, выбранной пользователем.
    private int temp = 14;
    public static final String APP_PREFERENCES = "mysettingss";
    private TextView ansverText;
    private TextView ansverName;
    private TextView ansverTextId;
    private List<Ansver> ansver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        temp = sharedPref.getInt("temp", temp);
        setHasOptionsMenu(true);
        if (savedInstanceState != null) {
            ansverId = savedInstanceState.getInt("ansverId");
        }
        return inflater.inflate(R.layout.fragment_ansver_text, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            AnsverLab ansverLab = AnsverLab.getInstance(getActivity());
            ansver = ansverLab.getAnsver();
            ansverName = view.findViewById(R.id.ansver_name);
            ansverText = view.findViewById(R.id.ansver_text);
            ansverTextId = view.findViewById(R.id.ansver_id);
            onRunAnsver(ansverId);
            ansverText.setTextSize((float) temp);//Размер текста песни.

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("temp", temp);
        editor.apply();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("ansverId", ansverId);
    }

    public void setAnsverId(int ansverId) {
        this.ansverId = ansverId;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_ansver_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inf = getActivity().getLayoutInflater();
                @SuppressLint("InflateParams") View view = inf.inflate(R.layout.dialog, null);
                builder.setView(view)
                        .setTitle("Размер шрифта")
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                final TextView text = view.findViewById(R.id.textView);
                text.setText(String.valueOf(temp));
                SeekBar seekBar = view.findViewById(R.id.seekBar);
                seekBar.setProgress(temp - 10);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        ansverText.setTextSize(progress + 10);
                        text.setText(String.valueOf(progress + 10));
                        temp = progress + 10;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.random_ansver:
                Random random = new Random();
                int randomNum = random.nextInt(ansver.size() - 1);
                onRunAnsver(randomNum);
                break;
            case R.id.share:
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String textToSend = (String) ansverText.getText();
                intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                try
                {
                    startActivity(Intent.createChooser(intent, "Описание действия"));
                }
                catch (android.content.ActivityNotFoundException ex) {}
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void onRunAnsver(int num) {
        ansverName.setText(ansver.get(num).getName());
        ansverText.setText(ansver.get(num).getText());
        ansverTextId.setText(ansver.get(num).getId() + "");
    }
}

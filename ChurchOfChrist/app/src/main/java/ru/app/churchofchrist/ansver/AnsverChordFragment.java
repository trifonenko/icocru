package ru.app.churchofchrist.ansver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.app.churchofchrist.R;

/**
 * Фрагмент показвает аккорды песни.
 */
public class AnsverChordFragment extends Fragment {
    private String ansverName;
    private static final String KEY = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            ansverName = savedInstanceState.getString(KEY);
        }
        return inflater.inflate(R.layout.fragment_chords_ansver, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView textAnsver = view.findViewById(R.id.text_chords);

        AnsverLab ansverLab = AnsverLab.getInstance(getActivity());
        List<Ansver> ansver = ansverLab.getAnsver();
        for (int i = 0; i < ansver.size(); i++) {
            if (ansverName.equals(ansver.get(i).getName())) {
                //textAnsver.setText(ansver.get(i).getChordsResId());
                break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY, ansverName);
    }

    public void setAnsverName(String ansverName) {
        this.ansverName = ansverName;
    }

}

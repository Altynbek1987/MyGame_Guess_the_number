package com.example.mygame_guess_the_number;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class Fragment_Screen_Result extends Fragment {
    TextView result;
    int point = 0;
    private Integer total;
    private static final String ARGUMENT = "total1";

    public Fragment_Screen_Result() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen__result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result = view.findViewById(R.id.Screen_result);
        Random random = new Random();
        int randomIndex = random.nextInt((100) + 1);
        int raznitsa;
        raznitsa = randomIndex - total;
        Log.d("ololo", "Правильный ответ " + randomIndex);
        if (randomIndex == total) {
            result.setText("Ураа!!! Да ты вундеркинд. Заработал +100 очков ");
            point = point + 100;
        } else if (raznitsa <= 5 && raznitsa >= 1) {
            result.setText("Чуть-чуть промахнулся. Утешительный приз +50 очков ");

        } else if (raznitsa <= 10 && raznitsa >= 6) {
            result.setText("Почти угадал. + 0 очков ");
            point = point + 0;

        } else if (raznitsa <= 20 && raznitsa >= 11) {
            result.setText("Ты прохмахнулся. Не рекомендую играть в лоторею. - 20 очков ");

        } else if (raznitsa <= 30 && raznitsa >= 21) {
            result.setText("Промах. Это фиаско вратишка. - 30 очков ");

        } else if (raznitsa <= 40 && raznitsa >= 31) {
            result.setText("Ни фига не понял, но очень интересно - 50 очков ");

        } else if (raznitsa <= 60 && raznitsa >= 41) {
            result.setText("Ну не правильно! Ебани ты артист! -60 очков ");

        } else {
            result.setText("Не правильно! ");
            point = point - 60;
        }

    }

    public static Fragment_Screen_Result newInstance(Integer total1) {
        Fragment_Screen_Result fragment_screen = new Fragment_Screen_Result();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT, total1);
        fragment_screen.setArguments(args);
        return fragment_screen;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            total = getArguments().getInt(ARGUMENT);
            Log.d("ololo", "" + total);
        }
    }
}

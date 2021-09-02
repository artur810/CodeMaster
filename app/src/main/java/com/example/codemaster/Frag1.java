package com.example.codemaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    Button buttonStartGame;
    ProgressBar ProgressBar;
    private Spinner levelNumber;
    private final String[] numberLevel = {"עד 1 פעמים מכל צבע", "עד 2 פעמים מכל צבע", "עד 3 פעמים מכל צבע", "עד 4 פעמים מכל צבע"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag1_layuot, container, false);

        buttonStartGame = view.findViewById(R.id.startGame);
        ProgressBar = view.findViewById(R.id.progressBar);
        levelNumber = view.findViewById(R.id.levelNumber);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, numberLevel);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelNumber.setAdapter(adapter);

        buttonStartGame.setOnClickListener(view1 -> {
            ProgressBar.setVisibility(View.VISIBLE);
            buttonStartGame.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getContext(), game.class);
                    intent.putExtra("numberLevel", String.valueOf(adapter.getPosition(numberLevel[levelNumber.getSelectedItemPosition()]) + 1));
                    getContext().startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    ProgressBar.setVisibility(View.GONE);
                    buttonStartGame.setClickable(true);
                }
            }, 500);
        });

        return view;
    }

}
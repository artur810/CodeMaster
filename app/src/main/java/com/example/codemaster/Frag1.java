package com.example.codemaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    Button buttonStartGame;
    ProgressBar ProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag1_layuot, container, false);

        buttonStartGame = view.findViewById(R.id.startGame);
        ProgressBar = view.findViewById(R.id.progressBar);

        buttonStartGame.setOnClickListener(view1 -> {
            ProgressBar.setVisibility(View.VISIBLE);
            buttonStartGame.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getContext(), game.class);
                    getContext().startActivity(intent);
                    ProgressBar.setVisibility(View.GONE);
                    buttonStartGame.setClickable(true);
                }
            }, 1000);
        });

        return view;
    }

}
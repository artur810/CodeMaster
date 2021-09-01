package com.example.codemaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    Button buttonStartGame;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag1_layuot, container, false);

        buttonStartGame = view.findViewById(R.id.startGame);

        buttonStartGame.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), game.class);
            getContext().startActivity(intent);
        });

        return view;
    }

}
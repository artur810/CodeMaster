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
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragStartGame extends Fragment {
    Button buttonStartGame;
    ProgressBar ProgressBar;
    private Spinner levelNumber, colors;
    private final String[] numberLevel = {"עד 1 פעמים מכל צבע", "עד 2 פעמים מכל צבע", "עד 3 פעמים מכל צבע", "עד 4 פעמים מכל צבע"};
    private final String[] colorNumber = {"עד 4 צבעים", "עד 5 צבעים", "עד 6 צבעים"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_start_game_layuot, container, false);

        buttonStartGame = view.findViewById(R.id.startGame);
        ProgressBar = view.findViewById(R.id.progressBar);
        levelNumber = view.findViewById(R.id.levelNumber);
        colors = view.findViewById(R.id.colors);

        ArrayAdapter<String> adapterLevel = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, numberLevel);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelNumber.setAdapter(adapterLevel);

        ArrayAdapter<String> adapterColor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorNumber);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colors.setAdapter(adapterColor);

        buttonStartGame.setOnClickListener(view1 -> {
            ProgressBar.setVisibility(View.VISIBLE);
            buttonStartGame.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getContext(), game.class);
                    intent.putExtra("numberLevel", String.valueOf(adapterLevel.getPosition(numberLevel[levelNumber.getSelectedItemPosition()]) + 1));
                    intent.putExtra("numberColors", String.valueOf(adapterColor.getPosition(colorNumber[colors.getSelectedItemPosition()]) + 4));
                    getContext().startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    ProgressBar.setVisibility(View.GONE);
                    buttonStartGame.setClickable(true);
                    getActivity().finish();
                }
            }, 500);
        });

        return view;
    }

}
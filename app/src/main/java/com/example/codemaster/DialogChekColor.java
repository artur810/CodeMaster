package com.example.codemaster;

import static com.example.codemaster.game.colors;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogChekColor extends DialogFragment {

    Button red, green, blue, yellow, gray, pink;

    private Button button;
    int numberColors;

    public DialogChekColor(Button button, int numberColors) {
        this.button = button;
        this.numberColors = numberColors;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.check_colors, container, false);

        red = view.findViewById(R.id.red);
        green = view.findViewById(R.id.green);
        blue = view.findViewById(R.id.blue);
        yellow = view.findViewById(R.id.yellow);
        gray = view.findViewById(R.id.gray);
        pink = view.findViewById(R.id.pink);

        red.setBackgroundColor(colors[0]);
        green.setBackgroundColor(colors[1]);
        blue.setBackgroundColor(colors[2]);
        yellow.setBackgroundColor(colors[3]);
        gray.setBackgroundColor(colors[4]);
        pink.setBackgroundColor(colors[5]);

        if(numberColors == 5){
            gray.setVisibility(View.VISIBLE);
        }

        if(numberColors == 6){
            gray.setVisibility(View.VISIBLE);
            pink.setVisibility(View.VISIBLE);
        }

        red.setOnClickListener(v -> {

            button.setBackgroundColor(colors[0]);
            button.setTag(colors[0]);
            this.dismiss();

        });
        green.setOnClickListener(v -> {

            button.setBackgroundColor(colors[1]);
            button.setTag(colors[1]);
            this.dismiss();

        });
        blue.setOnClickListener(v -> {

            button.setBackgroundColor(colors[2]);
            button.setTag(colors[2]);
            this.dismiss();

        });
        yellow.setOnClickListener(v -> {

            button.setBackgroundColor(colors[3]);
            button.setTag(colors[3]);
            this.dismiss();

        });
        gray.setOnClickListener(v -> {

            button.setBackgroundColor(colors[4]);
            button.setTag(colors[4]);
            this.dismiss();

        });
        pink.setOnClickListener(v -> {

            button.setBackgroundColor(colors[5]);
            button.setTag(colors[5]);
            this.dismiss();

        });

        return view;
    }

}
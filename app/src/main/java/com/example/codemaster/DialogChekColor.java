package com.example.codemaster;

import static com.example.codemaster.Frag2.buttonCheck;
import static com.example.codemaster.Frag2.colors;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogChekColor extends DialogFragment {

    Button red, green, blue, yellow;
    public static int check;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.check_colors, container, false);

        red = view.findViewById(R.id.red);
        green = view.findViewById(R.id.green);
        blue = view.findViewById(R.id.blue);
        yellow = view.findViewById(R.id.yellow);

        red.setBackgroundColor(colors[0]);
        green.setBackgroundColor(colors[1]);
        blue.setBackgroundColor(colors[2]);
        yellow.setBackgroundColor(colors[3]);

        red.setOnClickListener(v -> {

            buttonCheck.setBackgroundColor(colors[0]);
            check = 0;
            this.dismiss();

        });
        green.setOnClickListener(v -> {

            buttonCheck.setBackgroundColor(colors[1]);
            check = 1;
            this.dismiss();

        });
        blue.setOnClickListener(v -> {

            buttonCheck.setBackgroundColor(colors[2]);
            check = 2;
            this.dismiss();

        });
        yellow.setOnClickListener(v -> {

            buttonCheck.setBackgroundColor(colors[3]);
            check = 3;
            this.dismiss();

        });

        return view;
    }

}

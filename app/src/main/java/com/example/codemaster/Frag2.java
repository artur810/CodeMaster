package com.example.codemaster;

import static com.example.codemaster.DialogChekColor.check;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class Frag2 extends Fragment {

    Random rand = new Random();
    public static Button buttonColor, buttonCheck, buttonTest;
    public static int[] colors = new int[4];
    int n;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag2_layuot, container, false);

        buttonColor = view.findViewById(R.id.button);
        buttonCheck = view.findViewById(R.id.check);
        buttonTest = view.findViewById(R.id.test);

        colors[0] = Color.rgb(255,0,0);
        colors[1] = Color.rgb(0,255,0);
        colors[2] = Color.rgb(0,0,255);
        colors[3] = Color.rgb(255,255,0);

        check = rand.nextInt(4);
        buttonCheck.setBackgroundColor(colors[check]);

        n = rand.nextInt(4);
        buttonColor.setBackgroundColor(colors[n]);

        buttonColor.setOnClickListener(v -> {

            n = rand.nextInt(4);
            buttonColor.setBackgroundColor(colors[n]);

        });

        buttonCheck.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor();
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog fragment");

        });

        buttonTest.setOnClickListener(v -> {

            if(check == n){
                Toast.makeText(getActivity().getBaseContext(), "nice check", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getActivity().getBaseContext(), "try again", Toast.LENGTH_SHORT).show();
            }

        });

        return view;
    }
}

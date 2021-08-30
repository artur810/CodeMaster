package com.example.codemaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frag2 extends Fragment {

    Random rand = new Random();
    public static MaterialButton buttonCheck0, buttonCheck1, buttonCheck2, buttonCheck3, buttonTest;
    public static int[] colors = new int[4];

    RecyclerView recyclerview;
    private List<Card> cards;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag2_layuot, container, false);

        cards = new ArrayList<>();

        recyclerview = view.findViewById(R.id.recyclerview);

        buttonTest = view.findViewById(R.id.test);
        buttonCheck0 = view.findViewById(R.id.check0);
        buttonCheck1 = view.findViewById(R.id.check1);
        buttonCheck2 = view.findViewById(R.id.check2);
        buttonCheck3 = view.findViewById(R.id.check3);

        colors[0] = Color.RED;
        colors[1] = Color.GREEN;
        colors[2] = Color.BLUE;
        colors[3] = Color.YELLOW;

        buttonCheck0.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck0);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck1.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck1);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck2.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck2);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck3.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck3);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog fragment");

        });

        buttonTest.setOnClickListener(v -> {

            Card card = new Card((int)buttonCheck0.getTag(), (int)buttonCheck1.getTag(), (int)buttonCheck2.getTag(), (int)buttonCheck3.getTag());

            Toast.makeText(view.getContext(), card.getColor1() + "\n" + card.getColor2() + "\n" + card.getColor3() + "\n" +card.getColor4() + "\n", Toast.LENGTH_SHORT).show();

            cards.add(card);
            recyclerViewAdapter(view);

        });

        return view;
    }

    private void recyclerViewAdapter(View view){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(view.getContext(), cards);
        recyclerview.setAdapter(adapter);
    }
}

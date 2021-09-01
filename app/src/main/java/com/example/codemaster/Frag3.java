package com.example.codemaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Frag3 extends Fragment {

    RecyclerView recyclerViewShow;
    List<Card> cardsShow;
    private RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3_layuot, container, false);

        recyclerViewShow = view.findViewById(R.id.recyclerviewShow);
        cardsShow = new ArrayList<>();

        cardsShow = game.cards;

        if(cardsShow != null){
            recyclerViewAdapter(view);
        }

        return view;
    }

    private void recyclerViewAdapter(View view){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewShow.setHasFixedSize(true);
        recyclerViewShow.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(view.getContext(), cardsShow);
        recyclerViewShow.setAdapter(adapter);
    }

}
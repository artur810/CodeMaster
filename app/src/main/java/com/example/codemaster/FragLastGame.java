package com.example.codemaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.haozhang.lib.SlantedTextView;
import java.util.ArrayList;
import java.util.List;

public class FragLastGame extends Fragment {

    RecyclerView recyclerViewShow;
    List<Card> cardsShow;
    private RecyclerViewAdapter adapter;
    SlantedTextView noData;
    TextView lastGame;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3_layuot, container, false);

        recyclerViewShow = view.findViewById(R.id.recyclerviewShow);
        cardsShow = new ArrayList<>();
        noData= view.findViewById(R.id.noData);
        lastGame = view.findViewById(R.id.lastGame);

        cardsShow = game.cards;

        if(cardsShow != null && !cardsShow.isEmpty()){
            recyclerViewAdapter(view);
            noData.setVisibility(View.GONE);
            lastGame.setVisibility(View.VISIBLE);
            recyclerViewShow.setVisibility(View.VISIBLE);
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
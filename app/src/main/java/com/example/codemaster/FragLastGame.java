package com.example.codemaster;

import static com.example.codemaster.game.cards;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    Button buttonClear;
    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_last_name_layuot, container, false);

        recyclerViewShow = view.findViewById(R.id.recyclerviewShow);
        cardsShow = new ArrayList<>();
        noData= view.findViewById(R.id.noData);
        buttonClear = view.findViewById(R.id.buttonClear);
        ConstraintLayout = view.findViewById(R.id.ConstraintLayout);

        cardsShow = PrefConfig.readListFromPref(getContext());

        if(cardsShow != null && !cardsShow.isEmpty()){
            recyclerViewAdapter(view);
            noData.setVisibility(View.GONE);
            ConstraintLayout.setVisibility(View.VISIBLE);
            recyclerViewShow.setVisibility(View.VISIBLE);
        }

        buttonClear.setOnClickListener(v -> {
            cards = new ArrayList<>();
            PrefConfig.writeListInPref(getContext(), cards);
            noData.setVisibility(View.VISIBLE);
            ConstraintLayout.setVisibility(View.GONE);
            recyclerViewShow.setVisibility(View.GONE);
        });

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
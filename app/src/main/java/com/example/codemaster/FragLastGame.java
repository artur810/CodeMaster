package com.example.codemaster;

import static android.content.Context.MODE_PRIVATE;
import static com.example.codemaster.game.MY_PREFS_NAME;
import static com.example.codemaster.game.cards;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    Button buttonClear, seeCheckComputers0, seeCheckComputers1, seeCheckComputers2, seeCheckComputers3;
    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout, ConstraintLayoutCheckComputer;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_last_name_layuot, container, false);

        recyclerViewShow = view.findViewById(R.id.recyclerviewShow);
        cardsShow = new ArrayList<>();
        noData= view.findViewById(R.id.noData);
        buttonClear = view.findViewById(R.id.buttonClear);
        seeCheckComputers0 = view.findViewById(R.id.seeCheckComputers0);
        seeCheckComputers1 = view.findViewById(R.id.seeCheckComputers1);
        seeCheckComputers2 = view.findViewById(R.id.seeCheckComputers2);
        seeCheckComputers3 = view.findViewById(R.id.seeCheckComputers3);
        ConstraintLayout = view.findViewById(R.id.ConstraintLayoutInfo);
        ConstraintLayoutCheckComputer = view.findViewById(R.id.ConstraintLayoutCheckComputer);

        seeCheckComputers0.setClickable(false);
        seeCheckComputers1.setClickable(false);
        seeCheckComputers2.setClickable(false);
        seeCheckComputers3.setClickable(false);

        SharedPreferences prefs = getContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String buttonCheckComputers0 = prefs.getString("buttonCheckComputers0", null);
        String buttonCheckComputers1 = prefs.getString("buttonCheckComputers1", null);
        String buttonCheckComputers2 = prefs.getString("buttonCheckComputers2", null);
        String buttonCheckComputers3 = prefs.getString("buttonCheckComputers3", null);

        try{
            seeCheckComputers0.setBackgroundColor(Integer.valueOf(buttonCheckComputers0));
            seeCheckComputers1.setBackgroundColor(Integer.valueOf(buttonCheckComputers1));
            seeCheckComputers2.setBackgroundColor(Integer.valueOf(buttonCheckComputers2));
            seeCheckComputers3.setBackgroundColor(Integer.valueOf(buttonCheckComputers3));
        }catch(NumberFormatException ex){
        }

        cardsShow = PrefConfig.readListFromPref(getContext());

        if(cardsShow != null && !cardsShow.isEmpty()){
            recyclerViewAdapter(view);
            noData.setVisibility(View.GONE);
            ConstraintLayout.setVisibility(View.VISIBLE);
            ConstraintLayoutCheckComputer.setVisibility(View.VISIBLE);
            recyclerViewShow.setVisibility(View.VISIBLE);
        }

        buttonClear.setOnClickListener(v -> {
            cards = new ArrayList<>();
            PrefConfig.writeListInPref(getContext(), cards);
            noData.setVisibility(View.VISIBLE);
            ConstraintLayout.setVisibility(View.GONE);
            ConstraintLayoutCheckComputer.setVisibility(View.GONE);
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
package com.example.codemaster;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game extends AppCompatActivity {

    Random rand = new Random();
    public static MaterialButton buttonCheck0, buttonCheck1, buttonCheck2, buttonCheck3, buttonTest;
    public static MaterialButton buttonCheckComputers0, buttonCheckComputers1, buttonCheckComputers2, buttonCheckComputers3;
    public static int[] colors = new int[4];
    public static int[] checkComputers = new int[4];
    RecyclerView recyclerview;
    public static List<Card> cards;
    private RecyclerViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Intent intent = getIntent();
        String numberLevel = intent.getStringExtra("numberLevel");

        cards = new ArrayList<>();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerViewAdapter();

        buttonTest = findViewById(R.id.test);
        buttonCheck0 = findViewById(R.id.check0);
        buttonCheck1 = findViewById(R.id.check1);
        buttonCheck2 = findViewById(R.id.check2);
        buttonCheck3 = findViewById(R.id.check3);

        colors[0] = Color.RED;
        colors[1] = Color.GREEN;
        colors[2] = Color.BLUE;
        colors[3] = Color.YELLOW;

        checkColors(numberLevel);

        buttonCheckComputers0 = findViewById(R.id.checkComputers0);
        buttonCheckComputers1 = findViewById(R.id.checkComputers1);
        buttonCheckComputers2 = findViewById(R.id.checkComputers2);
        buttonCheckComputers3 = findViewById(R.id.checkComputers3);

        buttonCheckComputers0.setBackgroundColor(checkComputers[0]);
        buttonCheckComputers1.setBackgroundColor(checkComputers[1]);
        buttonCheckComputers2.setBackgroundColor(checkComputers[2]);
        buttonCheckComputers3.setBackgroundColor(checkComputers[3]);

        buttonCheckComputers0.setClickable(false);
        buttonCheckComputers1.setClickable(false);
        buttonCheckComputers2.setClickable(false);
        buttonCheckComputers3.setClickable(false);

        buttonCheck0.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck0);
            dialogFragment.show(getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck1.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck1);
            dialogFragment.show(getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck2.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck2);
            dialogFragment.show(getSupportFragmentManager(), "dialog fragment");

        });
        buttonCheck3.setOnClickListener(v -> {

            DialogChekColor dialogFragment = new DialogChekColor(buttonCheck3);
            dialogFragment.show(getSupportFragmentManager(), "dialog fragment");

        });

        buttonTest.setOnClickListener(v -> {

            if(buttonCheck0.getTag() != null && buttonCheck1.getTag() != null && buttonCheck2.getTag() != null && buttonCheck3.getTag() != null){

                Card card = new Card((int)buttonCheck0.getTag(), (int)buttonCheck1.getTag(), (int)buttonCheck2.getTag(), (int)buttonCheck3.getTag());

                cards.add(card);
                recyclerViewAdapter();

            }else {

                Toast.makeText(getApplication(), "you have to check colors", Toast.LENGTH_SHORT).show();

            }

        });

    }

    private void recyclerViewAdapter(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewAdapter(this, cards);
        recyclerview.setAdapter(adapter);

    }

    private void checkColors(String numberLevel){
        int times1 = 10, times2 = 10, times3 = 10, times4 = 10;

        if(numberLevel.equals("4")){
            checkComputers[0] = colors[rand.nextInt(4)];
            checkComputers[1] = colors[rand.nextInt(4)];
            checkComputers[2] = colors[rand.nextInt(4)];
            checkComputers[3] = colors[rand.nextInt(4)];
        }else if(numberLevel.equals("3")){
            times1 = rand.nextInt(4);
            checkComputers[0] = colors[times1];
            times2 = rand.nextInt(4);
            checkComputers[1] = colors[times2];
            times3 = rand.nextInt(4);
            checkComputers[2] = colors[times3];
            do{
                times4 = rand.nextInt(4);
            }while (times4 == times1 && times4 == times2 && times4 == times3);
            checkComputers[3] = colors[times4];
        }else if(numberLevel.equals("2")){
            times1 = rand.nextInt(4);
            checkComputers[0] = colors[times1];
            times2 = rand.nextInt(4);
            checkComputers[1] = colors[times2];
            do{
                times3 = rand.nextInt(4);
            }while (times3 == times1 && times3 == times2);
            checkComputers[2] = colors[times3];
            do{
                times4 = rand.nextInt(4);
            }while (times4 == times1 && times4 == times2 || times4 == times2 && times4 == times3 || times4 == times1 && times4 == times3);
            checkComputers[3] = colors[times4];
        }else if(numberLevel.equals("1")){
            times1 = rand.nextInt(4);
            checkComputers[0] = colors[times1];
            do{
                times2 = rand.nextInt(4);
            }while (times2 == times1);
            checkComputers[1] = colors[times2];
            do{
                times3 = rand.nextInt(4);
            }while (times3 == times1 || times3 == times2);
            checkComputers[2] = colors[times3];
            do{
                times4 = rand.nextInt(4);
            }while (times4 == times1 || times4 == times2 || times4 == times3);
            checkComputers[3] = colors[times4];
        }

    }

}
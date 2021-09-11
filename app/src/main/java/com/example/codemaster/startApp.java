package com.example.codemaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class startApp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_app);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(startApp.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 1000);

    }
}
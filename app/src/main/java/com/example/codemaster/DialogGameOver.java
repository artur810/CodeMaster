package com.example.codemaster;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGameOver extends DialogFragment {

    Button button;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme()){
            @Override
            public void onBackPressed() {
            }
        };
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_over, container, false);

        getDialog().setCanceledOnTouchOutside(false);

        button = view.findViewById(R.id.returnMain);

        CountDownTimer cuentaRegresiva = new CountDownTimer(10000, 100){
            @Override
            public void onTick(long millisUntilFinished) {
                long segundos = millisUntilFinished/1000+1;
                long minutos;
                if (segundos>= 60) {
                    minutos = segundos / 60;
                    segundos = segundos - minutos * 60;
                }
            }

            @Override
            public void onFinish() {
                openMainActivity();
            }

        }.start();

        button.setOnClickListener(v -> {

            cuentaRegresiva.cancel();
            openMainActivity();

        });

        return view;
    }

    public void openMainActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}

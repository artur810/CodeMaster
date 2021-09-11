package com.example.codemaster;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGameOver extends DialogFragment {

    Button returnMain, gameAgain;
    TextView textView;
    int numInfo;
    String numberLevel, numberColors;

    public DialogGameOver(int numInfo, String numberLevel, String numberColors) {
        this.numInfo = numInfo;
        this.numberLevel = numberLevel;
        this.numberColors = numberColors;
    }

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

        returnMain = view.findViewById(R.id.returnMain);
        gameAgain = view.findViewById(R.id.gameAgain);
        textView = view.findViewById(R.id.textInfo);

        textView.setText("הצלחת למצוא את הרצף הנכון תוך " + numInfo + " תורות");

        CountDownTimer cuentaRegresiva = new CountDownTimer(5000, 100){
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                openMainActivity();
            }

        }.start();

        returnMain.setOnClickListener(v -> {

            cuentaRegresiva.cancel();
            openMainActivity();

        });

        gameAgain.setOnClickListener(v -> {

            cuentaRegresiva.cancel();

            Intent intent = new Intent(getActivity(), game.class);
            intent.putExtra("numberLevel", numberLevel);
            intent.putExtra("numberColors", numberColors);
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            getActivity().finish();

        });

        return view;
    }

    public void openMainActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
package com.example.codemaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Card> list;
    private LayoutInflater mInflater;
    int n=0;

    RecyclerViewAdapter(Context context, List<Card> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override @SuppressLint("SetTextI18n")
    public void onBindViewHolder(ViewHolder holder, int position) {
        Card card = list.get(position);

        holder.color0.setBackgroundColor(card.getColor1());
        holder.color1.setBackgroundColor(card.getColor2());
        holder.color2.setBackgroundColor(card.getColor3());
        holder.color3.setBackgroundColor(card.getColor4());

        holder.color0.setClickable(false);
        holder.color1.setClickable(false);
        holder.color2.setClickable(false);
        holder.color3.setClickable(false);

        holder.result.setText(card.getStrikes());

        holder.number.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       MaterialButton color0, color1, color2, color3;
       TextView result, number;

        ViewHolder(View itemView) {
            super(itemView);

            color0 = itemView.findViewById(R.id.color0);
            color1 = itemView.findViewById(R.id.color1);
            color2 = itemView.findViewById(R.id.color2);
            color3 = itemView.findViewById(R.id.color3);

            result = itemView.findViewById(R.id.result);
            number = itemView.findViewById(R.id.number);

        }
    }

}
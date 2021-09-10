package com.example.codemaster;

import static android.content.Context.MODE_PRIVATE;
import static com.example.codemaster.game.MY_PREFS_NAME;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
    private Context mContext;

    RecyclerViewAdapter(Context context, List<Card> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
        this.mContext = context;
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

        SharedPreferences prefs = mContext.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String buttonCheckComputers0 = prefs.getString("buttonCheckComputers0", null);
        String buttonCheckComputers1 = prefs.getString("buttonCheckComputers1", null);
        String buttonCheckComputers2 = prefs.getString("buttonCheckComputers2", null);
        String buttonCheckComputers3 = prefs.getString("buttonCheckComputers3", null);

        holder.result.setText(card.getStrikes(Integer.valueOf(buttonCheckComputers0), Integer.valueOf(buttonCheckComputers1), Integer.valueOf(buttonCheckComputers2), Integer.valueOf(buttonCheckComputers3)));

        holder.number.setText(String.valueOf(position + 1));
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
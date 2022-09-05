package com.example.quizapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.database.Entity.User;

import java.util.List;

public class RangkingAdapter extends RecyclerView.Adapter<RangkingAdapter.ViewAdapter> {

    private List<User> listUser;
    private Context context;

    public RangkingAdapter(Context context , List<User> listUser) {
        this.context = context;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public RangkingAdapter.ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rangking_list,parent,false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RangkingAdapter.ViewAdapter holder, int position) {
        holder.labelUser.setText(listUser.get(position).username);
        holder.labelScore.setText(String.valueOf(listUser.get(position).score));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

     class ViewAdapter extends RecyclerView.ViewHolder {

        TextView labelUser, labelScore;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);

            //initialization component
            labelUser = itemView.findViewById(R.id.labelUserRangking);
            labelScore = itemView.findViewById(R.id.labelScoreRangking);
        }
    }
}

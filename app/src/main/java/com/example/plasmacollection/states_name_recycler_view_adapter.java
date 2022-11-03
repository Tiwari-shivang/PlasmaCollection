package com.example.plasmacollection;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class states_name_recycler_view_adapter extends RecyclerView.Adapter<states_name_recycler_view_adapter.ViewHolder>{

    Context context_from_starting_from_here_activity;
    ArrayList<String> name_of_states;

    states_name_recycler_view_adapter (Context context_from_starting_from_here_activity , ArrayList<String> name_of_states)
    {
        this.context_from_starting_from_here_activity = context_from_starting_from_here_activity;
        this.name_of_states = name_of_states;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View single_state_view = LayoutInflater.from(context_from_starting_from_here_activity).inflate(R.layout.each_state , parent , false);
        ViewHolder viewHolder = new ViewHolder(single_state_view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.state_name_text_view.setText(name_of_states.get(position));
    }

    @Override
    public int getItemCount() {
        return name_of_states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView state_name_text_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            state_name_text_view = itemView.findViewById(R.id.State_Name);
        }

    }

}

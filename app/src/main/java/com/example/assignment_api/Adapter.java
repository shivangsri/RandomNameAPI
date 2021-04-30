package com.example.assignment_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_api.Model.Results;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Results> results;

    public Adapter(Context context, List<Results> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final Results a=results.get(position);
        holder.mr.setText(a.getName().getTitle());
        holder.first.setText(a.getName().getFirst());
        holder.second.setText(a.getName().getLast());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mr;
        TextView first;
        TextView second;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mr=itemView.findViewById(R.id.mr);
            first=itemView.findViewById(R.id.first);
            second=itemView.findViewById(R.id.textView3);
        }
    }
}

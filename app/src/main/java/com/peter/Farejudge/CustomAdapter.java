package com.peter.Farejudge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    private Context context;
   private ArrayList name;
    private ArrayList service;
    private final ArrayList date;
    private final ArrayList review;
    CustomAdapter(Context context, ArrayList name, ArrayList service, ArrayList date, ArrayList review){

        this.context = context;
        this.name =name;
        this.service = service;
        this.review =review;
        this.date = date;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.service_txt.setText(String.valueOf(service.get(position)));
//        holder.review_txt.setText(String.valueOf(review.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_txt,service_txt,review_txt,date_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.name1);
            service_txt =itemView.findViewById(R.id.service1);
            review_txt = itemView.findViewById(R.id.review1);
            date_txt =itemView.findViewById(R.id.date1);

        }
    }
}

package com.example.drawerlayout2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<CardItemModel> cardItemModels;
    public RecyclerViewAdapter(Context context, ArrayList<CardItemModel> cardItemModels){
        this.context = context;
        this.cardItemModels = cardItemModels;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout (render the item)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assigning values to the views we created in the recycler_view_row layout file
        //based on the position of the recycler view

        holder.TVName.setText(cardItemModels.get(position).getItemName());
        holder.TVItemNum.setText(cardItemModels.get(position).getItemNumber());
        holder.imageView.setImageResource(cardItemModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        //the number of items we want to display
        return cardItemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from recycler view layout file
        //onCreate method for recycler view

        ImageView imageView;
        TextView TVName, TVItemNum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.IVimage);
            TVName = itemView.findViewById(R.id.TVItemName);
            TVItemNum = itemView.findViewById(R.id.TVItemNum);

        }

    }
}


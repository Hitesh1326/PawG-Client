package com.petfinder.pawg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * This class is used to display the text and image in recyclerview.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Paws> listItem;
    private Context context;

    public MyAdapter(List<Paws> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        ViewHolder vHolder = new ViewHolder(v);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Paws list = listItem.get(position);
        if(list != null) {

            holder.textPaws.setText(list.getAnimalDesc());
            Glide.with(context).load(list.getImg()).into(holder.petImage);
        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView petImage;
         public TextView textPaws;


        public ViewHolder(View itemView) {
            super(itemView);

            petImage = (ImageView) itemView.findViewById(R.id.petImage);
            textPaws = (TextView) itemView.findViewById(R.id.textPaws);

        }
    }
}

package com.example.telegram;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TelegramRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    public List<Telegram> list;

    public TelegramRecycleViewAdapter(List<Telegram> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            viewHolder.bind(getItem(position));
    }


   private Telegram getItem(int position)
   {
        return list.get(position);
   }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

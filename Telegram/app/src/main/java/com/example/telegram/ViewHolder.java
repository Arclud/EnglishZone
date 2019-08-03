package com.example.telegram;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView title;
    private TextView recentlyText;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.avatar);
        title = itemView.findViewById(R.id.title);
        recentlyText = itemView.findViewById(R.id.recentlyText);
    }

    public void bind(Telegram item) {
        title.setText(item.getTitle());
        recentlyText.setText(item.getRecentlyText());


        Glide
                .with(imageView)
                .load(item.getURL())
                .into(imageView);

    }
}


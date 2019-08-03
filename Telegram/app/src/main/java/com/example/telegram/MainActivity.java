package com.example.telegram;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);


        TelegramRecycleViewAdapter adapter = new TelegramRecycleViewAdapter(getSource());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
    private List<Telegram> getSource()
    {
        List<Telegram> list = new ArrayList<>();
        list.add(new Telegram("Trener" , "Where is my PlayMarket?","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzANLaWG0BELwqVmsnoNw-mSISJ1-sjKMB1ZENMy3mMtlxWK8JUg"));
        list.add(new Telegram("Kasem" , "Ok!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSl_N3HcRdQdGIwlaAf4fkLdXSCxEdVMnqjfvg-mtjpPZV0QwFg"));
        list.add(new Telegram("Maksim" , "Sorry","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa2ljvWkasSqMAwnhe5-qW6TBUCmCkDqaoNbed0WgAncZIuZwg"));
        list.add(new Telegram("Izat" , "Gavno ne tonet!!!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2CUc71pqKqW0UkvYEJQmpSYjwZ8slOCzXvrtzv0dSYuQfoQ3w"));
        list.add(new Telegram("Rustem" , "Are you ready?","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeygUlT-CcljjryhX-AyKOaBQOOZOkLRQKobbI-DblDZy_GBXIXA"));
        list.add(new Telegram("Temirlan" , "no!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1BFNTvMm8gWgv-qzbtOvNaUMUUaIfGXW37qhhMYukhjt5HfuFrQ"));
        list.add(new Telegram("Timur" , "Bye","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoJvlyzIjF115pxu95LQwG0z7NXPcvxjjK4y_OWHSKrM6yoGE_"));
        list.add(new Telegram("Azim" , "see you later","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMyJ7fYQmMc1KlZNjlJtHY9_RmNsnPXllR4G4ERMHwF5eN_3sG-w"));
        list.add(new Telegram("Nurs" , "Good job guys","data:image/jpeg;base64,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"));
        return list;
    }
}

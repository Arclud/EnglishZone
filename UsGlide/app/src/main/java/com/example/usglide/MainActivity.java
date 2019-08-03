package com.example.usglide;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SetImageAdapter adapter;
    ImageView imageView;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        text = "https://www.nasa.gov/sites/default/files/thumbnails/image/plasmatourhr_orbit1.0090.jpg";

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getView();
                getImage(adapter);

            }
        });
        //getView();



    }
    public void getImage(SetImageAdapter imageAdapter)
    {
        Glide
                .with(imageView)
                .load(imageAdapter.getURL())
                .into(imageView);


    }
    public List<SetImageAdapter> getView()
    {
        List<SetImageAdapter> list = new ArrayList<>();

        list.add(new SetImageAdapter("https://www.nasa.gov/sites/default/files/thumbnails/image/plasmatourhr_orbit1.0090.jpg"));
        adapter = new SetImageAdapter("https://www.nasa.gov/sites/default/files/thumbnails/image/plasmatourhr_orbit1.0090.jpg");
        return list;

    }

}

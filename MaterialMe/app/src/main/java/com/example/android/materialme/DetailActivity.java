package com.example.android.materialme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView sportImage;
    TextView sportTitle, secondTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Fetch intent and find views
        Intent intent = getIntent();
        sportImage = findViewById(R.id.sportsImageDetail);
        sportTitle = findViewById(R.id.titleDetail);

        // Use Glide to load image
        Glide.with(this).load(intent.getIntExtra("image_resource", 0)).into(sportImage);

        // Add title text to view
        sportTitle.setText(intent.getStringExtra("title"));



    }
}

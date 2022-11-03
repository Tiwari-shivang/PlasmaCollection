package com.example.plasmacollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Donor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        //All View IDs are here
        CardView remember_points_donation = findViewById(R.id.remember);
        ImageView cancel = findViewById(R.id.close_This_View);

        Animation up_to_down = AnimationUtils.loadAnimation(Donor.this, R.anim.up_to_down);


        cancel.setOnClickListener(view -> {
            remember_points_donation.startAnimation(up_to_down);
            remember_points_donation.setVisibility(View.GONE);
        });



    }
}
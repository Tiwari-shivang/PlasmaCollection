package com.example.plasmacollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class startingFromHere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_from_here);

        TextView countryNewCases = findViewById(R.id.numberOfCases);
        TextView countryDeaths = findViewById(R.id.numberOfDeaths);
        TextView stateNewCases = findViewById(R.id.casesInState);
        TextView stateDeaths = findViewById(R.id.DeathInState);

        ProgressBar progressBarNewCasesCountry = findViewById(R.id.countryProgress);
        ProgressBar progressBarDeathsCountry = findViewById(R.id.countryProgressBarDeaths);

        ProgressBar progressBarNewCasesState = findViewById(R.id.stateProgressBar);
        ProgressBar progressBarDeathsState = findViewById(R.id.stateProgressBarDeath);

        progressBarNewCasesCountry.setProgress(15000);
        progressBarNewCasesCountry.setMax(20000);
        progressBarDeathsCountry.setProgress(700);
        progressBarDeathsCountry.setMax(1000);

        progressBarNewCasesState.setProgress(1500);
        progressBarNewCasesState.setMax(5000);
        progressBarDeathsState.setProgress(80);
        progressBarDeathsState.setMax(1000);


    }
}
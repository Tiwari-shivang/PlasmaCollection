package com.example.plasmacollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class startingFromHere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_from_here);

        ArrayList<String> names_of_state = new ArrayList<String>();

        // All Views Id are here---------------------------------------------------------------


        ImageView cancel = findViewById(R.id.close_window);

        ViewPager viewPagerForServices = findViewById(R.id.SlideToServices);

        TextView countryNewCases = findViewById(R.id.NumberOfCasesDigits);
        TextView countryDeaths = findViewById(R.id.NumberOfDeathsDigits);
        TextView stateNewCases = findViewById(R.id.NumberOfCasesStateDigits);
        TextView stateDeaths = findViewById(R.id.NumberOfDeathsDigitsState);
        TextView heading_state_progress_services = findViewById(R.id.Some_Services);

        ProgressBar progressBarNewCasesCountry = findViewById(R.id.countryProgress);
        ProgressBar progressBarDeathsCountry = findViewById(R.id.countryProgressBarDeaths);

        ProgressBar progressBarNewCasesState = findViewById(R.id.StateProgress);
        ProgressBar progressBarDeathsState = findViewById(R.id.StateProgressBarDeaths);

        CardView state_cases_card = findViewById(R.id.stateCasesCard);
        CardView states_list = findViewById(R.id.states_list);

        AppCompatButton open_window = findViewById(R.id.Open_window);
        AppCompatButton choose_states = findViewById(R.id.choose_states);

        RelativeLayout state_description = findViewById(R.id.state_description);

        RecyclerView all_states_list = findViewById(R.id.all_states_list);

        //-------------------------------------------------------------------------------------


        //Animation declarations---------------------------------------------------------------
        Animation up_to_down_animation = AnimationUtils.loadAnimation(startingFromHere.this,R.anim.up_to_down);
        Animation left_to_right_animation = AnimationUtils.loadAnimation(startingFromHere.this,R.anim.left_to_right);
        Animation down_to_up_animation = AnimationUtils.loadAnimation(startingFromHere.this,R.anim.down_to_up);
        Animation right_to_left_animation = AnimationUtils.loadAnimation(startingFromHere.this,R.anim.right_to_left);
        Animation fade_in = AnimationUtils.loadAnimation(startingFromHere.this , R.anim.fade_in);
        Animation fade_out = AnimationUtils.loadAnimation(startingFromHere.this,R.anim.fade_out);
        //-------------------------------------------------------------------------------------

        //Progress bar for country new cases
        progressBarNewCasesCountry.setMax(150000);
        ObjectAnimator animateProgressNewCaseCounty = ObjectAnimator.ofInt(progressBarNewCasesCountry,"progress" , 0 , 100000);
        animateProgressNewCaseCounty.setDuration(2000);
        animateProgressNewCaseCounty.start();
        animateProgressNewCaseCounty.setInterpolator(new LinearInterpolator());

        //Text Animation for country new cases
        ValueAnimator animate_country_new_cases = new ValueAnimator();
        animate_country_new_cases.setObjectValues(50000,100000);
        animate_country_new_cases.addUpdateListener(valueAnimator -> countryNewCases.setText(String.valueOf(valueAnimator.getAnimatedValue())));
        animate_country_new_cases.setDuration(2000);
        animate_country_new_cases.start();

        //Progress bar for country deaths
        progressBarDeathsCountry.setMax(500);
        ObjectAnimator animateProgressNewDeaths = ObjectAnimator.ofInt(progressBarDeathsCountry,"progress",0,200);
        animateProgressNewDeaths.setDuration(2000);
        animateProgressNewDeaths.setInterpolator(new LinearInterpolator());
        animateProgressNewDeaths.start();

        //Text Animation for country deaths
        ValueAnimator animate_country_deaths = new ValueAnimator();
        animate_country_deaths.setObjectValues(100,200);
        animate_country_deaths.addUpdateListener(valueAnimator -> countryDeaths.setText(String.valueOf(valueAnimator.getAnimatedValue())));
        animate_country_deaths.setDuration(2000);
        animate_country_deaths.start();

        //Progress bar for state new cases
        progressBarNewCasesState.setMax(20000);
        ObjectAnimator animateProgressNewCasesState = ObjectAnimator.ofInt(progressBarNewCasesState,"progress",0,5000);
        animateProgressNewCasesState.setDuration(2000);
        animateProgressNewCasesState.setInterpolator(new LinearInterpolator());
        animateProgressNewCasesState.start();

        //Text Animation for state new cases
        ValueAnimator animate_state_new_cases = new ValueAnimator();
        animate_state_new_cases.setObjectValues(1000 , 5000);
        animate_state_new_cases.addUpdateListener(valueAnimator -> stateNewCases.setText(String.valueOf(valueAnimator.getAnimatedValue())));
        animate_state_new_cases.setDuration(2000);
        animate_state_new_cases.start();

        //Progress bar for state deaths
        progressBarDeathsState.setMax(50);
        ObjectAnimator animateProgressNewDeathState = ObjectAnimator.ofInt(progressBarDeathsState,"progress",0,10);
        animateProgressNewDeathState.setInterpolator(new LinearInterpolator());
        animateProgressNewDeathState.setDuration(1000);
        animateProgressNewDeathState.start();

        //Text animation for state deaths
        ValueAnimator animate_state_deaths = new ValueAnimator();
        animate_state_deaths.setObjectValues(5,10);
        animate_state_deaths.addUpdateListener(valueAnimator -> stateDeaths.setText(String.valueOf(valueAnimator.getAnimatedValue())));
        animate_state_deaths.setDuration(1000);
        animate_state_deaths.start();

        viewPagerAdapterForServices viewPagerAdapterForServices = new viewPagerAdapterForServices(getSupportFragmentManager());
        viewPagerForServices.setAdapter(viewPagerAdapterForServices);

        cancel.setOnClickListener(view -> {
            viewPagerForServices.setVisibility(View.VISIBLE);
            viewPagerForServices.startAnimation(left_to_right_animation);
            state_cases_card.startAnimation(up_to_down_animation);
            state_cases_card.setVisibility(View.GONE);
            open_window.setVisibility(View.VISIBLE);
            heading_state_progress_services.setText("Some Services");
        });

        open_window.setOnClickListener(view -> {
            state_cases_card.setVisibility(View.VISIBLE);
            state_cases_card.startAnimation(down_to_up_animation);
            viewPagerForServices.startAnimation(right_to_left_animation);
            viewPagerForServices.setVisibility(View.GONE);
            heading_state_progress_services.setText("State Details");
            open_window.setVisibility(View.GONE);
        });

        choose_states.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state_description.startAnimation(fade_out);
                state_description.setVisibility(View.INVISIBLE);

                states_list.setVisibility(View.VISIBLE);
                states_list.startAnimation(down_to_up_animation);

                state_cases_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        states_list.startAnimation(up_to_down_animation);
                        states_list.setVisibility(View.GONE);

                        state_description.setVisibility(View.VISIBLE);
                        state_description.startAnimation(fade_in);
                    }
                });

            }
        });

        names_of_state.add("Delhi");
        names_of_state.add("Mumbai");
        names_of_state.add("Kolkata");
        names_of_state.add("Uttar Pradesh");
        names_of_state.add("Gujrat");
        names_of_state.add("Assam");
        names_of_state.add("Tamil Nadu");
        names_of_state.add("Bihar");
        names_of_state.add("jammu");
        names_of_state.add("Kashmir");
        names_of_state.add("Chennai");
        names_of_state.add("Goa");
        names_of_state.add("Rajasthan");

        all_states_list.setLayoutManager(new LinearLayoutManager(startingFromHere.this , LinearLayoutManager.VERTICAL , false));

        states_name_recycler_view_adapter adapter_for_state_representation = new states_name_recycler_view_adapter(startingFromHere.this,names_of_state);
        all_states_list.setAdapter(adapter_for_state_representation);



    }
}
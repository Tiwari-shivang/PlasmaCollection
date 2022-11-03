package com.example.plasmacollection;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BecomeDonor extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup becomeDonor = (ViewGroup) inflater.inflate(R.layout.fragment_become_donor , container,false);

        CardView becomeDonorCard = becomeDonor.findViewById(R.id.becomeADonorCard);
        becomeDonorCard.setOnClickListener(view -> {
            Intent navigate_to_Donor_activity = new Intent(getActivity() , Donor.class);
            startActivity(navigate_to_Donor_activity);
        });

        return becomeDonor;
    }
}
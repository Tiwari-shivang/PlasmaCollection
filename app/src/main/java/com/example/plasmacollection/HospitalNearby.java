package com.example.plasmacollection;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HospitalNearby extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup HospitalNearbyLocation = (ViewGroup) inflater.inflate(R.layout.fragment_hospital_nearby,container,false);

        CardView hospitalNearbyCard = HospitalNearbyLocation.findViewById(R.id.HospitalNearbyLoc);
        hospitalNearbyCard.setOnClickListener(view -> {
            Intent navigate_to_NearyHospital = new Intent(getActivity() , NearyHospital.class);
            startActivity(navigate_to_NearyHospital);
        });

        return HospitalNearbyLocation;
    }
}
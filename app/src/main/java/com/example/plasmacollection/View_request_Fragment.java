package com.example.plasmacollection;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class View_request_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup Request_View_Fragment = (ViewGroup) inflater.inflate(R.layout.fragment_view_requests,container,false);


        return Request_View_Fragment;
    }
}
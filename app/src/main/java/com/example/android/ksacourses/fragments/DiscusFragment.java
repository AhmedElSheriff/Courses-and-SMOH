package com.example.android.ksacourses.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.ksacourses.R;

public class DiscusFragment extends android.support.v4.app.Fragment {

    public DiscusFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discus_fragment,container,false);

        return view;
    }
}

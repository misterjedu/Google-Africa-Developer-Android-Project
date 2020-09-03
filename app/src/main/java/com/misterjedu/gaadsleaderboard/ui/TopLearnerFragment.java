package com.misterjedu.gaadsleaderboard.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misterjedu.gaadsleaderboard.R;

public class TopLearnerFragment extends Fragment {

    public TopLearnerFragment() {
        // Required empty public constructor
    }

    public static TopLearnerFragment newInstance(String param1, String param2) {
        TopLearnerFragment fragment = new TopLearnerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_learner, container, false);
    }
}
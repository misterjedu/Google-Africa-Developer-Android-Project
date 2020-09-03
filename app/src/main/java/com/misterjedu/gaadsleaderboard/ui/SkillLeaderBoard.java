package com.misterjedu.gaadsleaderboard.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misterjedu.gaadsleaderboard.R;

public class SkillLeaderBoard extends Fragment {

    public SkillLeaderBoard() {
        // Required empty public constructor
    }

    public static SkillLeaderBoard newInstance(String param1, String param2) {
        SkillLeaderBoard fragment = new SkillLeaderBoard();
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
        return inflater.inflate(R.layout.fragment_skill_leader_board, container, false);
    }
}
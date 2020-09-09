package com.misterjedu.gaadsleaderboard.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misterjedu.gaadsleaderboard.R;

public class SkillIqFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    public SkillIqFragment() {
        // Required empty public constructor
    }

    public static SkillIqFragment newInstance(String param1, String param2) {
        SkillIqFragment fragment = new SkillIqFragment();
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
//        return inflater.inflate(R.layout.fragment_skill_leader_board, container, false);
        View view = inflater.inflate(R.layout.fragment_skill_leader_board, container, false);
        mRecyclerView = view.findViewById(R.id.skill_leader_recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(requireContext());
//        mAdapter = new ResultRecyclerAdapter()

    }

}
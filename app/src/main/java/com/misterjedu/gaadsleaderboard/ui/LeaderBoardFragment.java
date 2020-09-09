package com.misterjedu.gaadsleaderboard.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.ui.adapter.LeaderBoardPageAdapter;

import java.util.Objects;

public class LeaderBoardFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private LeaderBoardPageAdapter viewPagerAdapter;

    public LeaderBoardFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LeaderBoardFragment newInstance(String param1, String param2) {
        LeaderBoardFragment fragment = new LeaderBoardFragment();
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
        return inflater.inflate(R.layout.fragment_leader_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Get references to tablayout, viewpager views and instantiate the viewpager adapter
        tabLayout = view.findViewById(R.id.gads_tablayout);
        viewPager = view.findViewById(R.id.leaderboard_viewpager);
        viewPagerAdapter = new LeaderBoardPageAdapter(Objects.requireNonNull
                (getActivity()).getSupportFragmentManager(),getLifecycle());
        setTabToViewPager();

        //Set Onclick listener on submit button to start the submission activity.
        Button goToSubmissionButton = view.findViewById(R.id.submit_activity_button);
        goToSubmissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), ProjectSubmissionActivity.class);
                startActivity(intent);
            }
        });

    }

    //Connect the viewpager to the adapter and use a Mediator to mediate tabs and viewpagers
    private void setTabToViewPager() {
        viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position == 0){
                            tab.setText("Learning Leaders");
                        }else if(position == 1){
                            tab.setText("Skill IQ");
                        }
                    }
                }
        ).attach();
    }
}
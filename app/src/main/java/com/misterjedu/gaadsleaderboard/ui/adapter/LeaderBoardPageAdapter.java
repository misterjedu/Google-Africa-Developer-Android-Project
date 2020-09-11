package com.misterjedu.gaadsleaderboard.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.misterjedu.gaadsleaderboard.ui.SkillIqFragment;
import com.misterjedu.gaadsleaderboard.ui.TopLearnerFragment;

/**
 * View Pager Adapter for the leader board and SkillIq fragments
 */
public class LeaderBoardPageAdapter extends FragmentStateAdapter {

    public LeaderBoardPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       if(position == 0){
           return new TopLearnerFragment();
       }else if(position == 1){
           return new SkillIqFragment();
       }else {
           return new TopLearnerFragment();
       }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

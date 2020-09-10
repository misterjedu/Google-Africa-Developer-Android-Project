package com.misterjedu.gaadsleaderboard.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.data.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultRecyclerAdapter extends RecyclerView.Adapter<ResultRecyclerAdapter.ResultViewHolder> {

    private List<Result> mResultList;
    private String fragmentName;

    public ResultRecyclerAdapter(List<Result> resultList, String nameOfFragment) {
        fragmentName = nameOfFragment;
        mResultList = resultList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (fragmentName.equals("TopLearner")) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_top_learner_view, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_skill_iq_leader, parent, false);
        }

        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Result currentResult = mResultList.get(position);
        holder.resultName.setText(currentResult.getName());
        holder.resultStats.setText(currentResult.getStats());
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        public TextView resultName;
        public TextView resultStats;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);

            if (fragmentName.equals("TopLearner")) {
                resultName = itemView.findViewById(R.id.learner_name);
                resultStats = itemView.findViewById(R.id.learner_stats);
            } else if (fragmentName.equals("SkillIq")) {
                resultName = itemView.findViewById(R.id.skill_iq_leader_name);
                resultStats = itemView.findViewById(R.id.skill_iq_leader_stats);
            }
        }
    }
}

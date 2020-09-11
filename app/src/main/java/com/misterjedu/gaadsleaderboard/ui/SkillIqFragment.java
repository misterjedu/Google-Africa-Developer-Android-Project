package com.misterjedu.gaadsleaderboard.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.data.Result;
import com.misterjedu.gaadsleaderboard.requests.LeaderboardApi;
import com.misterjedu.gaadsleaderboard.requests.ServiceGenerator;
import com.misterjedu.gaadsleaderboard.requests.responsemodel.SkillIqResponse;
import com.misterjedu.gaadsleaderboard.ui.adapter.ResultRecyclerAdapter;
import com.misterjedu.gaadsleaderboard.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        View view = inflater.inflate(R.layout.fragment_skill_leader_board, container, false);
        mRecyclerView = view.findViewById(R.id.skill_leader_recycler_view);

        //Set Base URL
        Constants.setBaseURL("gadurl");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set up Recycler view adapter
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(requireContext());

        makeRetrofitCall();

    }

    private void makeRetrofitCall() {
        LeaderboardApi leaderboardApi = ServiceGenerator.getLeaderboardApi();

        Call<List<SkillIqResponse>> responseCall = leaderboardApi.getSkillIq();

        responseCall.enqueue(new Callback<List<SkillIqResponse>>() {

            @Override
            public void onResponse(Call<List<SkillIqResponse>> call, Response<List<SkillIqResponse>> response) {
                if (response.code() == 200) {
                    List<SkillIqResponse> responseList = response.body();
                    List<Result> result = new ArrayList<>();

                    for (int i = 0; i < responseList.size(); i++) {
                        //Extract the Name, Hour and Country
                        String name = responseList.get(i).getName();
                        int score = responseList.get(i).getScore();
                        String country = responseList.get(i).getCountry();

                        //Create the stats string
                        String stats = score + " IQ Score, " + country;

                        //Use each value to create a new result object and add the the result list
                        result.add(new Result(name, stats));


                        //Set the Pass the List of result into the Recycler view using the adapter
                        if (result != null) {
                            mAdapter = new ResultRecyclerAdapter(result, "SkillIq");
                            mRecyclerView.setAdapter(mAdapter);
                            mRecyclerView.setLayoutManager(mLayoutManager);
                        } else {
                            try {
                                Log.i("Not 200", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<SkillIqResponse>> call, Throwable t) {
                Log.i("Failure", t.getMessage());
            }
        });
    }
}
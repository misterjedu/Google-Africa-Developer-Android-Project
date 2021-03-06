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
import android.widget.Button;
import android.widget.LinearLayout;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.data.Result;
import com.misterjedu.gaadsleaderboard.helpers.PageLoader;
import com.misterjedu.gaadsleaderboard.requests.LeaderboardApi;
import com.misterjedu.gaadsleaderboard.requests.ServiceGenerator;
import com.misterjedu.gaadsleaderboard.requests.responsemodel.LearningResponse;
import com.misterjedu.gaadsleaderboard.ui.adapter.ResultRecyclerAdapter;
import com.misterjedu.gaadsleaderboard.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopLearnerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private LinearLayout offlineLayout;
    private LinearLayout loadingLayout;

    private Button refreshButton;

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
        View view = inflater.inflate(R.layout.fragment_top_learner, container, false);

        //Set mode layouts
        mRecyclerView = view.findViewById(R.id.top_learner_recycler_view);
        offlineLayout = view.findViewById(R.id.top_learner_offline_layout);
        loadingLayout = view.findViewById(R.id.top_learner_loading_layout);

        //Refresh Page Button
        refreshButton =view.findViewById(R.id.top_learner_refresh_button);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set Recycler view adapter
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(requireContext());

        //Set Base URL
        Constants.setBaseURL("gadurl");

        makeRetrofitCall();

        //Refresh Button Make Retrofit call again
        refreshButton.setOnClickListener(view -> makeRetrofitCall());
    }

    //Make Retrofit Call
    private void makeRetrofitCall() {
        //Set Loading Page while request is ongoing
        PageLoader.loadLoading(mRecyclerView, offlineLayout, loadingLayout);

        LeaderboardApi leaderboardApi = ServiceGenerator.getLeaderboardApi();

        Call<List<LearningResponse>> responseCall = leaderboardApi.getApiHours();

        responseCall.enqueue(new Callback<List<LearningResponse>>() {

            //If get request is successful
            @Override
            public void onResponse(Call<List<LearningResponse>> call, Response<List<LearningResponse>> response) {
                if (response.code() == 200) {

                    //Set Loading Page while request is ongoing
                    PageLoader.loadOnline(mRecyclerView, offlineLayout, loadingLayout);


                    //Get the response body, which is an array of Learning response
                    List<LearningResponse> responseList = response.body();
                    List<Result> result = new ArrayList<>();

                    for (int i = 0; i < responseList.size(); i++) {
                        //Extract the Name, Hour and Country
                        String name = responseList.get(i).getName();
                        int hours = responseList.get(i).getHours();
                        String country = responseList.get(i).getCountry();

                        //Create the stats string
                        String stats = hours + " Learning hours, " + country;

                        //Use each value to create a new result object and add the the result list
                        result.add(new Result(name, stats));
                    }

                    //Set the Pass the List of result into the Recycler view using the adapter
                    if (result != null) {
                        mAdapter = new ResultRecyclerAdapter(result, "TopLearner");
                        mRecyclerView.setAdapter(mAdapter);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                    }
                } else {
                    try {
                        Log.i("Not 200", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //If request fails, Log the failure message
            @Override
            public void onFailure(Call<List<LearningResponse>> call, Throwable t) {
                //Set Loading Page while request is ongoing
                PageLoader.loadOffline(mRecyclerView, offlineLayout, loadingLayout);
                Log.i("Request Failure", t.getMessage());
            }
        });
    }
}













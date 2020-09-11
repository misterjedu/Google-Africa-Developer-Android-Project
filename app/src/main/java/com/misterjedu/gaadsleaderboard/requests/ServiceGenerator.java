package com.misterjedu.gaadsleaderboard.requests;

import com.misterjedu.gaadsleaderboard.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    //Generate the Retrofit Builder
    public static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.getBaseURL())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static LeaderboardApi leaderboardApi = retrofit.create(LeaderboardApi.class);

    //Return created retrofit builder
    public static LeaderboardApi getLeaderboardApi() {
        return leaderboardApi;
    }
}

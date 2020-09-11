package com.misterjedu.gaadsleaderboard.requests;

import android.util.Log;

import com.misterjedu.gaadsleaderboard.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    public static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.getBaseURL())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static LeaderboardApi leaderboardApi = retrofit.create(LeaderboardApi.class);

    public static LeaderboardApi getLeaderboardApi() {
        Log.i("Base Url", Constants.getBaseURL());
        return leaderboardApi;
    }


}

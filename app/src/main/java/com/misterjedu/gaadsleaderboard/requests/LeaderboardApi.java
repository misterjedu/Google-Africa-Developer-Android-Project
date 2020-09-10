package com.misterjedu.gaadsleaderboard.requests;

import com.misterjedu.gaadsleaderboard.requests.responsemodel.LearningResponse;
import com.misterjedu.gaadsleaderboard.requests.responsemodel.SkillIqResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderboardApi {
    //Get Learning Leaders List
    @GET("api/hours")
    Call<List<LearningResponse>> getApiHours();

    //Get Skill Iq List
    @GET("api/skilliq")
    Call<List<SkillIqResponse>> getSkillIq();

}

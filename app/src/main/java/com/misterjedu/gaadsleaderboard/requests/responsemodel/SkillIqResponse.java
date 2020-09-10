package com.misterjedu.gaadsleaderboard.requests.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillIqResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }


    public String getBadgeUrl() {
        return badgeUrl;
    }
}

package com.misterjedu.gaadsleaderboard.requests.responsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearningResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private Integer hours;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public Integer getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }


}

//    public void setScore(Integer score) {
//        this.score = score;
//    }
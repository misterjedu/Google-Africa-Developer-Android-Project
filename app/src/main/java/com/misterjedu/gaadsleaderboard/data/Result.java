package com.misterjedu.gaadsleaderboard.data;

public class Result {
    private String name;
    private String stats;

    //Result class with name and stats parameters
    public Result(String learnerName, String learnerStats) {
        name = learnerName;
        stats = learnerStats;
    }

    public String getName() {
        return name;
    }

    public String getStats() {
        return stats;
    }
}

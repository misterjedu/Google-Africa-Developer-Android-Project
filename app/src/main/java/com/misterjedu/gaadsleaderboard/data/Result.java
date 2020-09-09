package com.misterjedu.gaadsleaderboard.data;

public class Result {
    private String name;
    private String stats;

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

package com.trustedoffer.worldcupcricket2019;


public class HighScoreModelClass {
    private String name;
    private String run;
    private String team;

    public HighScoreModelClass(String name, String team, String run) {
        this.name = name;
        this.team = team;
        this.run = run;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getRun() {
        return run;
    }
}


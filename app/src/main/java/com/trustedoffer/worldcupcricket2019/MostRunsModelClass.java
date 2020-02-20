package com.trustedoffer.worldcupcricket2019;


public class MostRunsModelClass {
    private String player;
    private String runs;
    private String team;

    public MostRunsModelClass(String player, String team, String runs) {
        this.player = player;
        this.team = team;
        this.runs = runs;
    }

    public String getPlayer() {
        return player;
    }

    public String getTeam() {
        return team;
    }

    public String getRuns() {
        return runs;
    }
}


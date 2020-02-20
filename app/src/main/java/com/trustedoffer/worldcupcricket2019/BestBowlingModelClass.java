package com.trustedoffer.worldcupcricket2019;

public class BestBowlingModelClass {
    private String player;
    private String team;
    private String wicket;

    public BestBowlingModelClass(String player, String team, String wicket) {
        this.player = player;
        this.team = team;
        this.wicket = wicket;
    }

    public String getPlayer() {
        return player;
    }

    public String getTeam() {
        return team;
    }

    public String getWicket() {
        return wicket;
    }
}


package com.trustedoffer.worldcupcricket2019;


public class MostWicketModelClass {
    private String name;
    private String team;
    private String wicket;

    public MostWicketModelClass(String name, String team, String wicket) {
        this.name = name;
        this.team = team;
        this.wicket = wicket;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getWicket() {
        return wicket;
    }
}

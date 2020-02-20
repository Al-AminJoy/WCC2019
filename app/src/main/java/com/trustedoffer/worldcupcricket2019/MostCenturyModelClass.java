package com.trustedoffer.worldcupcricket2019;


public class MostCenturyModelClass {
    private String centuries;
    private String name;
    private String team;

    public MostCenturyModelClass(String name, String team, String centuries) {
        this.name = name;
        this.team = team;
        this.centuries = centuries;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getCenturies() {
        return centuries;
    }
}


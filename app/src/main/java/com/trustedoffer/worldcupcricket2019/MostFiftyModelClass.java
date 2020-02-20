package com.trustedoffer.worldcupcricket2019;


public class MostFiftyModelClass {
    private String fifty;
    private String name;
    private String team;

    public MostFiftyModelClass(String name, String team, String fifty) {
        this.name = name;
        this.team = team;
        this.fifty = fifty;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getFifty() {
        return fifty;
    }
}


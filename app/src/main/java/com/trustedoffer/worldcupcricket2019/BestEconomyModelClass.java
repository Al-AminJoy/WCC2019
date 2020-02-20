package com.trustedoffer.worldcupcricket2019;


public class BestEconomyModelClass {
    private String economy;
    private String name;
    private String team;

    public BestEconomyModelClass(String name, String team, String economy) {
        this.name = name;
        this.team = team;
        this.economy = economy;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getEconomy() {
        return economy;
    }
}

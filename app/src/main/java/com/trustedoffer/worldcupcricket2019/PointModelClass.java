package com.trustedoffer.worldcupcricket2019;


public class PointModelClass {
    String Ppoint;
    String lost;
    String netrr;
    String played;
    String team;
    String tie;
    String won;

    public PointModelClass(String team, String played, String won, String lost, String tie, String Ppoint, String netrr) {
        this.team = team;
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.tie = tie;
        this.Ppoint = Ppoint;
        this.netrr = netrr;
    }

    public String getTeam() {
        return team;
    }

    public String getPlayed() {
        return played;
    }

    public String getWon() {
        return won;
    }

    public String getLost() {
        return lost;
    }

    public String getTie() {
        return tie;
    }

    public String getPpoint() {
        return Ppoint;
    }

    public String getNetrr() {
        return netrr;
    }
}


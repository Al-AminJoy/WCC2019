package com.trustedoffer.worldcupcricket2019;

public class LiveScoreModelClass {
    private String batteamname,batteamimg,batteamscore,batteamover;
    private String bowlteamname,bowlteamimg,bowlteamscore,bowlteamover;
    private String target,type,status;

    public LiveScoreModelClass(String batteamname, String batteamimg, String batteamscore, String batteamover, String bowlteamname, String bowlteamimg, String bowlteamscore, String bowlteamover, String target,String type,String status) {
        this.batteamname = batteamname;
        this.batteamimg = batteamimg;
        this.batteamscore = batteamscore;
        this.batteamover = batteamover;
        this.bowlteamname = bowlteamname;
        this.bowlteamimg = bowlteamimg;
        this.bowlteamscore = bowlteamscore;
        this.bowlteamover = bowlteamover;
        this.target = target;
        this.type=type;
        this.status=status;
    }

    public String getBatteamname() {
        return batteamname;
    }

    public String getBatteamimg() {
        return batteamimg;
    }

    public String getBatteamscore() {
        return batteamscore;
    }

    public String getBatteamover() {
        return batteamover;
    }

    public String getBowlteamname() {
        return bowlteamname;
    }

    public String getBowlteamimg() {
        return bowlteamimg;
    }

    public String getBowlteamscore() {
        return bowlteamscore;
    }

    public String getBowlteamover() {
        return bowlteamover;
    }

    public String getTarget() {
        return target;
    }
    public String getType() {
        return type;
    }
    public String getStatus() {
        return status;
    }
}

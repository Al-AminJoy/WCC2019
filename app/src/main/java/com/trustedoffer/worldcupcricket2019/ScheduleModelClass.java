package com.trustedoffer.worldcupcricket2019;

public class ScheduleModelClass {
    String date;
    String leftCountry;
    String leftCountryImgUrl;
    String match;
    String rightCountry;
    String rightCountryImgUrl;
    String stadium;
    String status;
    String time;

    public ScheduleModelClass(String date, String time, String match, String stadium, String status, String leftCountry, String rightCountry, String leftCountryImgUrl, String rightCountryImgUrl) {
        this.date = date;
        this.time = time;
        this.match = match;
        this.stadium = stadium;
        this.status = status;
        this.leftCountry = leftCountry;
        this.rightCountry = rightCountry;
        this.leftCountryImgUrl = leftCountryImgUrl;
        this.rightCountryImgUrl = rightCountryImgUrl;
    }

    public String getDate() {
        return date;
    }

    public String getLeftCountry() {
        return leftCountry;
    }

    public String getLeftCountryImgUrl() {
        return leftCountryImgUrl;
    }

    public String getMatch() {
        return match;
    }

    public String getRightCountry() {
        return rightCountry;
    }

    public String getRightCountryImgUrl() {
        return rightCountryImgUrl;
    }

    public String getStadium() {
        return stadium;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }
}

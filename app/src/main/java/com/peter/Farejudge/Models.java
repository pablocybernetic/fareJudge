package com.peter.Farejudge;

public class Models {
    private String Loc_Name, image_url;
    private int date,rate;
    private Boolean active;

//    constructor


    public Models(String loc_Name, String image, int date, int rate, Boolean active) {
        Loc_Name = loc_Name;
        this.image_url = image_url;
        this.date = date;
        this.rate = rate;
        this.active = active;
    }

    public Models() {
    }
//    to String is necessart for printing the content of the classs

    @Override
    public String toString() {
        return "Models{" +
                "Loc_Name='" + Loc_Name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", date=" + date +
                ", rate=" + rate +
                ", active=" + active +
                '}';
    }

    //getters and setters
    public String getLoc_Name() {
        return Loc_Name;
    }

    public void setLoc_Name(String loc_Name) {
        Loc_Name = loc_Name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}


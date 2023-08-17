package com.example.jktvehicleapp.modelClass;

public class RideHistoryClass {
    String date,time,carName,picLoc,DropLoc;

    public RideHistoryClass(String date, String time, String carName, String picLoc, String dropLoc) {
        this.date = date;
        this.time = time;
        this.carName = carName;
        this.picLoc = picLoc;
        DropLoc = dropLoc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPicLoc() {
        return picLoc;
    }

    public void setPicLoc(String picLoc) {
        this.picLoc = picLoc;
    }

    public String getDropLoc() {
        return DropLoc;
    }

    public void setDropLoc(String dropLoc) {
        DropLoc = dropLoc;
    }
}

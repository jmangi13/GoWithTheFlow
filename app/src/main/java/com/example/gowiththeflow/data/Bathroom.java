package com.example.gowiththeflow.data;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class Bathroom {


    String name;
    GeoPoint location;
    String comment;
    ArrayList<Integer> toiletpaper;
    ArrayList<Integer> runningwater;

    public Bathroom(){}
    public Bathroom(String name, String comment, ArrayList<Integer> toiletpaper, ArrayList<Integer> runningwater, GeoPoint loc ){
        this.name = name; this.comment = comment; this.toiletpaper = toiletpaper; this.runningwater = runningwater; this.location = loc;
    }

    @Override
    public String toString() {
        String out = "";
        out += "name: " + name + "\n";
        out += "comment: " + comment + "\n";
        out += "location: ";
        out += (location == null) ? "" : location.toString() + "\n";
        out += "bathroom: ";
        out += (toiletpaper == null) ? "" : toiletpaper.toString() + "\n";
        out += "runningwater: ";
        out += (runningwater == null) ? "" : runningwater.toString() + "\n";

        return out;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

}

package com.example.gowiththeflow;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class Location {

    String id;
    String description;
    ArrayList<String> type;
    String name;
    String documentId;
    GeoPoint location;

    public Location() {
    }

    public Location(String id) {
        this.documentId = id;
    }

    @Override
    public String toString() {
        String out = "";
        out += "name: " + name + "\n";
        out += "id: " + documentId + "\n";
        out += "desc: " + description + "\n";
        out += "type: " + type + "\n";
        out += "location: ";
        out += (location == null) ? "" : location.toString() + "\n";

        return out;
    }

    public Location(String nameQ, String descQ, ArrayList<String> typeQ, GeoPoint loc ){
        name = nameQ; description = descQ; type = typeQ; location = loc;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPoint getlocation() {
        return location;
    }


    public void setlocation(GeoPoint temp) {
        location = temp;

    }

}
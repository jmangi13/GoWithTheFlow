package com.example.gowiththeflow.database;

import com.google.firebase.firestore.GeoPoint;

import java.util.HashMap;

public class Reading {

    public String name;
    String desc;
    String type;
    String documentId;
    GeoPoint location;

    public Reading() {
        return;
    }

    public Reading(String name, String type, String docID, String desc, GeoPoint location) {
        this.name = name;
        this.documentId = docID;
        this.desc = desc;
        this.type = type;
        this.location = location;
    }

    @Override
    public String toString() {
        String out = "";
        out += "name: " + name + "\n";
        out += "id: " + documentId + "\n";
        out += "desc: " + desc + "\n";
        out += "type: " + type + "\n";
        out += "location: ";
        out += (location == null) ? "" : location.toString() + "\n";

        return out;
    }
}

/*
String name;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    String desc;

    String type;

    String documentId;

    GeoPoint location;


    public Location(String id){
        this.documentId = id;
    }

//    public Location(String nameQ, String descQ, String typeQ, double locX, double locY ){
//        name = nameQ; desc = descQ; type = typeQ; locationX = locX; locationY = locY;
//    }


    @Override
    public String toString() {
        return this.name;
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
 */
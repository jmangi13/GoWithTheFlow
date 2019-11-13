package com.example.gowiththeflow.data;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class User {


    String name;
    String id;
    GeoPoint location;
    String tagline;
    ArrayList<Integer> friends;
    ArrayList<Integer> reviews;

    @Override
    public String toString() {
        String out = "";
        out += "name: " + name + "\n";
        out += "id: " + id + "\n";
        out += "tagline: " + tagline + "\n";
        out += "location: ";
        out += (location == null) ? "" : location.toString() + "\n";
        out += "friends: ";
        out += (friends == null) ? "" : friends.toString() + "\n";
        out += "reviews: ";
        out += (reviews == null) ? "" : reviews.toString() + "\n";

        return out;
    }
}

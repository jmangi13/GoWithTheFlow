package com.example.gowiththeflow.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Session {
    public String _id;
    public String _locationId;
    public ArrayList<Reading> _readings;
    public Date _startTime;
    public Date _endTime;


    public Session() {
        this._id = UUID.randomUUID().toString();
        this._locationId = UUID.randomUUID().toString();
        this._readings = new ArrayList<>();
        this._startTime = new Date();
        this._endTime = null;
    }

    public void addReading(Reading reading) {
        _readings.add(reading);
    }

    public void endSession() {
        _endTime = new Date();
    }

    @Override
    public String toString() {
        return _startTime.toString();
    }

}
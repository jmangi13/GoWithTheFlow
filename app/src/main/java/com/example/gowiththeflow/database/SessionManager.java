package com.example.gowiththeflow.database;

import com.example.gowiththeflow.Location;

public class SessionManager {
    private Session _session;
    private Location _location;
    private static SessionManager _instance;


    private SessionManager() {}

    public static SessionManager getInstance() {
        if (_instance == null) {
            _instance = new SessionManager();
        }
        return _instance;
    }

    public Session getSession() {
        return _session;
    }

    public void setSession(Session session) {
        _session = session;
    }

    public Location getPatient() { return _location; }

    public void setPatient(Location location) { _location = location; }

}


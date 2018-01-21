package com.example.user.polygonepoints;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 1/14/2018.
 */

public class Place {
    public String name;
    public LatLng latlng;


    public Place(String name, LatLng latlng) {
        this.name = name;
        this.latlng = latlng;
    }

    public String getName() {
        return name;
    }

    public LatLng getLatlng() {
        return latlng;
    }
}

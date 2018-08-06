package com.pikchillytechnologies.mounttour;

import android.widget.ImageView;
import android.widget.TextView;

public class Events {

    private int m_PlaceImageId;
    private String m_EventDate;
    private String m_PlaceName;
    private String m_Duration;
    private String m_Cost;
    private String m_Phone;

    public Events(int placeImageId, String eventDate, String placeName, String duration, String cost, String phone) {
        this.m_PlaceImageId = placeImageId;
        this.m_EventDate = eventDate;
        this.m_PlaceName = placeName;
        this.m_Duration = duration;
        this.m_Cost = cost;
        this.m_Phone = phone;
    }

    public int getM_PlaceImageId() {
        return m_PlaceImageId;
    }

    public void setM_PlaceImageId(int m_PlaceImageId) {
        this.m_PlaceImageId = m_PlaceImageId;
    }

    public String getM_EventDate() {
        return m_EventDate;
    }

    public void setM_EventDate(String m_EventDate) {
        this.m_EventDate = m_EventDate;
    }

    public String getM_PlaceName() {
        return m_PlaceName;
    }

    public void setM_PlaceName(String m_PlaceName) {
        this.m_PlaceName = m_PlaceName;
    }

    public String getM_Duration() {
        return m_Duration;
    }

    public void setM_Duration(String m_Duration) {
        this.m_Duration = m_Duration;
    }

    public String getM_Cost() {
        return m_Cost;
    }

    public void setM_Cost(String m_Cost) {
        this.m_Cost = m_Cost;
    }

    public String getM_Phone() {
        return m_Phone;
    }

    public void setM_Phone(String m_Phone) {
        this.m_Phone = m_Phone;
    }
}

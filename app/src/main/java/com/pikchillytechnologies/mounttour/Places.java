package com.pikchillytechnologies.mounttour;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Places implements Parcelable{

    private String m_PlaceName;
    private String m_CityName;
    private String m_StateName;
    private String m_About;
    private String m_HowToReach;
    private String m_Hotel;
    private String m_Bank;
    private String m_Medical;
    private int m_PlaceImageId1;
    private int m_PlaceImageId2;
    private int m_PlaceImageId3;

    public Places(String placeName, String cityName, String stateName, String about, String howToReach, String hotel, String bank, String medical,int placeImageId1, int placeImageId2, int placeImageId3){
        this.m_PlaceName = placeName;
        this.m_CityName = cityName;
        this.m_StateName = stateName;
        this.m_About = about;
        this.m_HowToReach = howToReach;
        this.m_Hotel = hotel;
        this.m_Bank = bank;
        this.m_Medical = medical;
        this.m_PlaceImageId1 = placeImageId1;
        this.m_PlaceImageId2 = placeImageId2;
        this.m_PlaceImageId3 = placeImageId3;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_PlaceName);
        dest.writeString(m_CityName);
        dest.writeString(m_StateName);
        dest.writeString(m_About);
        dest.writeString(m_HowToReach);
        dest.writeString(m_Hotel);
        dest.writeString(m_Bank);
        dest.writeString(m_Medical);
        dest.writeInt(m_PlaceImageId1);
        dest.writeInt(m_PlaceImageId2);
        dest.writeInt(m_PlaceImageId3);
    }

    private Places(Parcel in){
        m_PlaceName = in.readString();
        m_CityName = in.readString();
        m_StateName = in.readString();
        m_About = in.readString();
        m_HowToReach = in.readString();
        m_Hotel = in.readString();
        m_Bank = in.readString();
        m_Medical = in.readString();
        m_PlaceImageId1 = in.readInt();
        m_PlaceImageId2 = in.readInt();
        m_PlaceImageId3 = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Places> CREATOR = new Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel in) {
            return new Places(in);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };

    public String getM_CityName() {
        return m_CityName;
    }

    public void setM_CityName(String m_CityName) {
        this.m_CityName = m_CityName;
    }

    public String getM_StateName() {
        return m_StateName;
    }

    public void setM_StateName(String m_StateName) {
        this.m_StateName = m_StateName;
    }

    public String getM_PlaceName() {
        return m_PlaceName;
    }

    public void setM_PlaceName(String m_PlaceName) {
        this.m_PlaceName = m_PlaceName;
    }

    public int getM_PlaceImageId() {
        return m_PlaceImageId1;
    }

    public void setM_PlaceImageId1(int m_PlaceImageId1) {
        this.m_PlaceImageId1 = m_PlaceImageId1;
    }

    public String getM_About() {
        return m_About;
    }

    public void setM_About(String m_About) {
        this.m_About = m_About;
    }

    public String getM_HowToReach() {
        return m_HowToReach;
    }

    public void setM_HowToReach(String m_HowToReach) {
        this.m_HowToReach = m_HowToReach;
    }

    public String getM_Hotel() {
        return m_Hotel;
    }

    public void setM_Hotel(String m_Hotel) {
        this.m_Hotel = m_Hotel;
    }

    public String getM_Bank() {
        return m_Bank;
    }

    public void setM_Bank(String m_Bank) {
        this.m_Bank = m_Bank;
    }

    public String getM_Medical() {
        return m_Medical;
    }

    public void setM_Medical(String m_Medical) {
        this.m_Medical = m_Medical;
    }

    public int getM_PlaceImageId1() {
        return m_PlaceImageId1;
    }

    public int getM_PlaceImageId2() {
        return m_PlaceImageId2;
    }

    public void setM_PlaceImageId2(int m_PlaceImageId2) {
        this.m_PlaceImageId2 = m_PlaceImageId2;
    }

    public int getM_PlaceImageId3() {
        return m_PlaceImageId3;
    }

    public void setM_PlaceImageId3(int m_PlaceImageId3) {
        this.m_PlaceImageId3 = m_PlaceImageId3;
    }
}

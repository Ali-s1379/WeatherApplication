package com.example.weatherapplication;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String state;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public Weather() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

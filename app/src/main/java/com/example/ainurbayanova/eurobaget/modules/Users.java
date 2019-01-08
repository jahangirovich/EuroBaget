package com.example.ainurbayanova.eurobaget.modules;



public class Users {

    public String name;
    public int id;

    public String time;
    public String image;
    public Users(String name, String time, String image) {
        this.name = name;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}

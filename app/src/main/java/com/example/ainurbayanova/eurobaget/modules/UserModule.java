package com.example.ainurbayanova.eurobaget.modules;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserModule {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String image;

    public UserModule(String name, String image) {
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.example.ainurbayanova.eurobaget.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ainurbayanova.eurobaget.modules.UserModule;

import java.util.List;

@Dao
public interface UderDao {
    @Insert
    void insert(UserModule userModule);

    @Update
    void update(UserModule userModule);

    @Delete
    void delete(UserModule userModule);

    @Query("SELECT * FROM user_table ORDER BY name DESC")
    LiveData<List<UserModule>> getUserList();
}

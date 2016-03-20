package com.szuzyh.coolweather_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.Override;
import java.lang.String;

/**
 * Created by 27721_000 on 2016/3/19.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    //Province表建表语句
    public static final String CREATE_PROVINCE="create table Province ("
    +"id integer primary key autoincrement,"
    +"province_name text,"
    +"province_code text)";

    //City 表建表语句
    public static final String CREATE_CITY="create table City("
    +"id integer primary key aytoincrement,"
    +"city_name text,"
    +"city_code text,"
    +"province_id integer)";

    //County表建表语句

    public static final String CREATE_COUNTY="create table County("
    +"id integer primary key autoincrement,"
    +"county_name text,"
    +"county_code text,"
    +"city_id integer)";

    public CoolWeatherOpenHelper(Context context,String name,
                                 SQLiteDatabase.CursorFactory factory,
                                 int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建Province类
        db.execSQL(CREATE_CITY);//创建city类
        db.execSQL(CREATE_COUNTY);//创建county类
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

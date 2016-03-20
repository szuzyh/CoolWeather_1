package com.szuzyh.coolweather_1;

import android.text.TextUtils;

/**
 * Created by 27721_000 on 2016/3/20.
 */
public class Utility {

    //解析和处理服务器返回的省级数据
    public synchronized  static boolean handlerProvinceResponse(CoolWeatherDB coolWeatherDB
    ,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvince=response.split(",");
            if (allProvince!=null&&allProvince.length>0){
                for (String p:allProvince){
                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceName(array[0]);
                    province.setProvinceCode(array[1]);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return  false;
    }

    //解析和处理服务器返回的市级数据
    public static boolean handlerCitiesResponse(CoolWeatherDB coolWeatherDB,
                                          String response,int provinceId){
        if (!TextUtils.isEmpty(response)) {
            String[] allCities=response.split(",");
            if (allCities!=null&&allCities.length>0){
                for (String c:allCities){
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setCityName(array[0]);
                    city.setCityCode(array[1]);
                    city.setProvinceId(provinceId);
                    //将解析出来的数据存储到Citye表
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    //解析和处理服务器返回的县级数据
    public static boolean handlerCountiesResponse(CoolWeatherDB coolWeatherDB,
                                          String response,int cityId){
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties=response.split(",");
            if (allCounties!=null&&allCounties.length>0){
                for (String c:allCounties){
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCountyName(array[0]);
                    county.setCountyCode(array[1]);
                    county.setCityId(cityId);
                    //将解析出来的数据存储到Citye表
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }


}

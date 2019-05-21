package com.poni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 *@author:PONI_CHAN
 *@date:2019/4/9 22:42
 */
@Entity
public class WeatherInfo {

    @Id
    @GeneratedValue
    private String cityid;

    private String city;

    private String WD;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }
}

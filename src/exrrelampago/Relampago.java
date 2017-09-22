/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exrrelampago;

import java.util.Date;

/**
 *
 * @author 11944413600
 */
public class Relampago {
    private float latitude;
    private float longtitude;
    private Date data;
    private String desc;

    public Relampago(float latitude, float longtitude, Date data, String desc) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.data = data;
        this.desc = desc;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Override
    public String toString(){
        return this.getDesc();
    }
}

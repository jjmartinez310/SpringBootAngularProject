package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="physical_devices")
public class Physical_devices {

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="physical_deviceid")
    private int physical_deviceid;
    
    @Column(name="type")
    private String type;

    @Column(name="image_source")
    private String image_source;

    // define constructors

    public Physical_devices() {

    }

    public Physical_devices(int physical_deviceid, String type, String image_source, double price) {
        this.physical_deviceid = physical_deviceid;
        this.type = type;
        this.image_source = image_source;
    }
   
    //define getter/setter

    public int getPhysical_deviceid() {
        return physical_deviceid;
    }

    public void setPhysical_deviceid(int physical_deviceid) {
        this.physical_deviceid = physical_deviceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    //define toString

    @Override
    public String toString() {
        return "Physical_devices [type=" + type + ", image_source=" + image_source + ", physical_deviceid=" + physical_deviceid + "]";
    }


}
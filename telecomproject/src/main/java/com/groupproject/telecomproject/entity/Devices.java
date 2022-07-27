package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="devices")
public class Devices {

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="device_id")
    private int device_id;
    
    @Column(name="device_name")
    private String device_name;

    @Column(name="device_number")
    private String device_number;

    @Column(name="device_model")
    private String device_model;

    @Column(name="plan_id")
    private int plan_id;

    // define constructors

    public Devices() {

    }

    public Devices(int device_id, String device_name, String device_number, String device_model, int plan_id) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_number = device_number;
        this.device_model = device_model;
        this.plan_id = plan_id;
    }
   
    //define getter/setter

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_number() {
        return device_number;
    }

    public void setDevice_number(String device_number) {
        this.device_number = device_number;
    }
    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }
    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    //define toString

    @Override
    public String toString() {
        return "Devices [device_name=" + device_name + ", device_number=" + device_number + ", device_model=" + device_model + "]";
    }


}
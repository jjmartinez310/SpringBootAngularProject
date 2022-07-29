package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="devices",
        uniqueConstraints = @UniqueConstraint(columnNames = {"deviceNumber"}))
public class Devices {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="deviceName")
    private String deviceName;

    @Column(name="deviceNumber")
    private String deviceNumber;

    @Column(name="deviceModel")
    private String deviceModel;

    @Column(name="plan_id")
    private int planId;


    public Devices() {

    }

    public Devices(String deviceName, String deviceNumber, String deviceModel, int planId) {
        this.deviceName = deviceName;
        this.deviceNumber = deviceNumber;
        this.deviceModel = deviceModel;
        this.planId = planId;
    }


    public int getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }


    @Override
    public String toString() {
        return "Devices [deviceName=" + deviceName + ", device_id="+ id + "deviceNumber=" + deviceNumber + ", deviceModel=" + deviceModel + ", plan_id" + planId + "]";
    }


}
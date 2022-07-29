package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="plans")
public class Plans {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="plan_name")
    private String planName;

    @Column(name="plan_numlines")
    private int planNumlines;

    @Column(name="plan_price")
    private double planPrice;

    @Column(name="user_id")
    private int userId;


    public Plans() {

    }

    public Plans(String planName, int planNumlines, double planPrice, int userId) {
        this.planName= planName;
        this.planNumlines= planNumlines;
        this.planPrice = planPrice;
        this.userId = userId;
    }
   

    public int getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getPlanNumlines() {
        return planNumlines;
    }

    public void setPlanNumlines(int planNumlines) {
        this.planNumlines = planNumlines;
    }

    public double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Plans [plan_name=" + planName + ", plan_numlines=" + planNumlines + ", plan_price=" + planPrice + ", plan_id=" + id + ", user_id=" + userId + "]";
    }


}
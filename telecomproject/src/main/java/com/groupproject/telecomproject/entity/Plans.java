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

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="plan_id")
    private int plan_id;
    
    @Column(name="plan_name")
    private String plan_name;

    @Column(name="plan_numlines")
    private int plan_numlines;

    @Column(name="plan_price")
    private double plan_price;

    @Column(name="user_id")
    private int user_id;

    // define constructors

    public Plans() {

    }

    public Plans(int plan_id, String plan_name, int plan_numlines, double plan_price, int user_id) {
        this.plan_id = plan_id;
        this.plan_name = plan_name;
        this.plan_numlines = plan_numlines;
        this.plan_price = plan_price;
        this.user_id = user_id;
    }
   
    //define getter/setter

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public int getPlan_numlines() {
        return plan_numlines;
    }

    public void setPlan_numlines(int plan_numlines) {
        this.plan_numlines = plan_numlines;
    }

    public double getPlan_price() {
        return plan_price;
    }

    public void setPlan_price(double plan_price) {
        this.plan_price = plan_price;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    //define toString

    @Override
    public String toString() {
        return "Plans [plan_name=" + plan_name + ", plan_numlines=" + plan_numlines + ", plan_price=" + plan_price + ", plan_id=" + plan_id + ", user_id=" + user_id + "]";
    }


}
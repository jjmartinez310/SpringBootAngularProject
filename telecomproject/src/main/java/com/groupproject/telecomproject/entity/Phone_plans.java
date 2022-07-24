package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="phone_plans")
public class Phone_plans {

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="phone_planid")
    private int phone_planid;
    
    @Column(name="plan_name")
    private String plan_name;

    @Column(name="number_of_phones")
    private int number_of_phones;

    @Column(name="price")
    private double price;

    // define constructors

    public Phone_plans() {

    }

    public Phone_plans(int phone_planid, String plan_name, int number_of_phones, double price) {
        this.phone_planid = phone_planid;
        this.plan_name = plan_name;
        this.number_of_phones = number_of_phones;
        this.price = price;
    }
   
    //define getter/setter

    public int getPhone_planid() {
        return phone_planid;
    }

    public void setPhone_planid(int phone_planid) {
        this.phone_planid = phone_planid;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public int getNumber_of_phones() {
        return number_of_phones;
    }

    public void setNumber_of_phones(int number_of_phones) {
        this.number_of_phones = number_of_phones;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //define toString

    @Override
    public String toString() {
        return "Phone_plans [plan_name=" + plan_name + ", number_of_phones=" + number_of_phones + ", price=" + price + ", phone_planid=" + phone_planid + "]";
    }


}
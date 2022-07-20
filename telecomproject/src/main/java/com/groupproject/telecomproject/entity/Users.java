package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name="users")
public class Users {

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userid")
    private int userid;
    
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="phone_1")
    private String phone_1;

    @Column(name="phone_2")
    private String phone_2;

    @Column(name="phone_3")
    private String phone_3;

    @Column(name="phone_4")
    private String phone_4;

    @Column(name="phone_5")
    private String phone_5;

    @Column(name="phone_6")
    private String phone_6;

    // define constructors

    public Users() {

    }

    public Users(int userid, String first_name, String last_name, String phone_1, String phone_2, String phone_3,
            String phone_4, String phone_5, String phone_6) {
        this.userid = userid;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.phone_3 = phone_3;
        this.phone_4 = phone_4;
        this.phone_5 = phone_5;
        this.phone_6 = phone_6;
    }
   
    //define getter/setter

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
    }

    public String getPhone_3() {
        return phone_3;
    }

    public void setPhone_3(String phone_3) {
        this.phone_3 = phone_3;
    }

    public String getPhone_4() {
        return phone_4;
    }

    public void setPhone_4(String phone_4) {
        this.phone_4 = phone_4;
    }

    public String getPhone_5() {
        return phone_5;
    }

    public void setPhone_5(String phone_5) {
        this.phone_5 = phone_5;
    }

    public String getPhone_6() {
        return phone_6;
    }

    public void setPhone_6(String phone_6) {
        this.phone_6 = phone_6;
    }

    //define toString

    @Override
    public String toString() {
        return "Users [first_name=" + first_name + ", last_name=" + last_name + ", phone_1=" + phone_1 + ", phone_2="
                + phone_2 + ", phone_3=" + phone_3 + ", phone_4=" + phone_4 + ", phone_5=" + phone_5 + ", phone_6="
                + phone_6 + ", userid=" + userid + "]";
    }


}
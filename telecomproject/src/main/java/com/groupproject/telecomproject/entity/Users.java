package com.groupproject.telecomproject.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@Entity
@Table(name="users")
public class Users {

    // define fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="pass")
    private String pass;

    // define constructors

    public Users() {

    }

    public Users(String firstName, String lastName, String username, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pass = pass;
    }
   
    //define getter/setter

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //define toString

    @Override
    public String toString() {
        return "Users [first_name=" + firstName + ", last_name=" + lastName + ", username=" + username + ", pass=" + pass + ", user_id=" + id + "]";
    }


}
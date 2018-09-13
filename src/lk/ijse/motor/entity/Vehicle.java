/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.entity;

import javax.persistence.*;

/**
 *
 * @author Ranga Lankathilaka
 */
@Entity
public class Vehicle {

    @Id
  private  int vid;  
    private String type;
     private String issue;

     @ManyToOne(cascade = {CascadeType.REMOVE})
     @JoinColumn(name="cid",referencedColumnName = "cid")
     private  Customer customer;

    public Vehicle() {
    }

    public Vehicle(int vid, String type, String issue, Customer customer) {
        this.vid = vid;
        this.type = type;
        this.issue = issue;
        this.customer = customer;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vid=" + vid +
                ", type='" + type + '\'' +
                ", issue='" + issue + '\'' +
                ", customer=" + customer +
                '}';
    }
}

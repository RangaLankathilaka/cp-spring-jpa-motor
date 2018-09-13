/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ranga Lankathilaka
 */

@Entity
public class Customer {

    @Id
    private int cid;
    private String Cname;
    private int contact;
    private String address;



    @OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "customer")
    private List<Vehicle> vehicle=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "customer")
    private List<CustomerDetail> customerDetail=new ArrayList<>();


    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    @OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "customer")
    private List<Invoice> invoice=new ArrayList<>();

    public Customer() {
    }
    
    

    public Customer(int cid, String Cname, int contact, String address) {
        this.cid = cid;
        this.Cname = Cname;
        this.contact = contact;
        this.address = address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public List<CustomerDetail> getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(List<CustomerDetail> customerDetail) {
        this.customerDetail = customerDetail;
    }

    @Override
    public String toString() {
        return "Customer{" + "cid=" + cid + ", Cname=" + Cname + ", contact=" + contact + ", address=" + address + '}';
    }

    
    
    
}

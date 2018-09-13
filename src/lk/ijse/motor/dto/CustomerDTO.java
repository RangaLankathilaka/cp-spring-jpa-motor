/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dto;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerDTO {
     private int cid;
    private String Cname;
    private int contact;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(int cid, String Cname, int contact, String address) {
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

    @Override
    public String toString() {
        return "CustomerDTO{" + "cid=" + cid + ", Cname=" + Cname + ", contact=" + contact + ", address=" + address + '}';
    }
    
    
    
    
}

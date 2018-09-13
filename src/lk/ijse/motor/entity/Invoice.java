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

@NamedNativeQuery(name = "lastid",query ="select iid from invoice order by iid desc LIMIT 1 ")
@Entity
public class Invoice {
    @Id
    private int iid;
    private String discription;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cid",referencedColumnName = "cid")
    private Customer customer;

    @OneToMany(mappedBy = "invoice",cascade ={CascadeType.PERSIST,CascadeType.REMOVE} )
    private List<InvoiceDetail> invoiceDetail=new ArrayList<>();



    public Invoice() {

    }

    public Invoice(int iid, String discription, Customer customer) {
        this.iid = iid;
        this.discription = discription;
        this.customer = customer;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "iid=" + iid +
                ", discription='" + discription + '\'' +
                ", customer=" + customer +
                '}';
    }
}

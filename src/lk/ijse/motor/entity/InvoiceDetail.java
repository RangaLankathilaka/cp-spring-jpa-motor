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
public class InvoiceDetail {
//     pid           | int(11)     | NO   | PRI | NULL    |       |
//| iid           | int(11)     | NO   | PRI | NULL    |       |
//| detail        | varchar(45) | YES  |     | NULL    |       |
//| qty           | int(11)     | YES  |     | NULL    |       |
//| selling_price | int(11)     | YES  |     | NULL    |       |
//| total         | int(11)     | YES  |     | NULL    |       |
//| total_amount  | int(11)     |
    private String detail;
    private int qty;
    private int selling_price;
    private int total;
    private  int total_amount;
    @EmbeddedId
    private InvoiceDetail_PK invoiceDetail_PK;

    @ManyToOne
    @JoinColumn(name = "pid",referencedColumnName = "pid",insertable = false,updatable = false)
    private Part part;

    @ManyToOne
    @JoinColumn(name = "iid",referencedColumnName = "iid",insertable = false,updatable = false)
    private Invoice invoice;

    public InvoiceDetail() {
    }

    public InvoiceDetail(String detail, int qty, int selling_price, int total, int total_amount, InvoiceDetail_PK invoiceDetail_PK) {
        this.detail = detail;
        this.qty = qty;
        this.selling_price = selling_price;
        this.total = total;
        this.total_amount = total_amount;
        this.invoiceDetail_PK = invoiceDetail_PK;
    }
 public InvoiceDetail(String detail, int qty, int selling_price, int total, int total_amount,int iid,int pid) {
        this.detail = detail;
        this.qty = qty;
        this.selling_price = selling_price;
        this.total = total;
        this.total_amount = total_amount;
        this.invoiceDetail_PK = new InvoiceDetail_PK(iid,pid);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public InvoiceDetail_PK getInvoiceDetail_PK() {
        return invoiceDetail_PK;
    }

    public void setInvoiceDetail_PK(InvoiceDetail_PK invoiceDetail_PK) {
        this.invoiceDetail_PK = invoiceDetail_PK;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" + "detail=" + detail + ", qty=" + qty + ", selling_price=" + selling_price + ", total=" + total + ", total_amount=" + total_amount + ", invoiceDetail_PK=" + invoiceDetail_PK + '}';
    }
   
    
  

   
    
}

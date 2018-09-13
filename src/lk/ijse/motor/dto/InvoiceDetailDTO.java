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
public class InvoiceDetailDTO {
    private  int pid;
    private  int iid;
     private String detail;
    private int qty;
    private int selling_price;
    private int total;
    private  int total_amount;

    public InvoiceDetailDTO() {
    }

    public InvoiceDetailDTO(int pid, int iid, String detail, int qty, int selling_price, int total, int total_amount) {
        this.pid = pid;
        this.iid = iid;
        this.detail = detail;
        this.qty = qty;
        this.selling_price = selling_price;
        this.total = total;
        this.total_amount = total_amount;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
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

    @Override
    public String toString() {
        return "InvoiceDetailDTO{" + "pid=" + pid + ", iid=" + iid + ", detail=" + detail + ", qty=" + qty + ", selling_price=" + selling_price + ", total=" + total + ", total_amount=" + total_amount + '}';
    }

   
    
    
    
    
    
}

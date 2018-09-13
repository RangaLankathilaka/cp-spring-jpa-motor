/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.view.util.tblmodel;

/**
 *
 * @author Ranga Lankathilaka
 */
public class ListTM {
    private  int pid;
    private  String pname;
    private  int selling_price;
    private  int qty;
    private  int total;

    public ListTM(int pid, String pname, int selling_price, int qty, int total) {
        this.pid = pid;
        this.pname = pname;
        this.selling_price = selling_price;
        this.qty = qty;
        this.total = total;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
    
    
    
}

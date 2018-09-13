/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dto;

import java.util.Date;

/**
 *
 * @author Ranga Lankathilaka
 */
public class CustomerDetailDTO {
    private  int cid;
   private  int pid;
    private  Date date;

    public CustomerDetailDTO() {
    }

    public CustomerDetailDTO(int cid, int pid, Date date) {
        this.cid = cid;
        this.pid = pid;
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerDetailDTO{" + "cid=" + cid + ", pid=" + pid + ", date=" + date + '}';
    }
    
    
    
}

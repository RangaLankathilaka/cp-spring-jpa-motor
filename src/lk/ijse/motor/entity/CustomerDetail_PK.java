/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Ranga Lankathilaka
 */

@Embeddable
public class CustomerDetail_PK implements Serializable {
    
    private  int cid;
    
   private  int pid; 

    public CustomerDetail_PK() {
    }

    public CustomerDetail_PK(int cid, int pid) {
        this.cid = cid;
        this.pid = pid;
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
   
   
   
   
    
}

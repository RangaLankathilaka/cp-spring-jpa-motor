/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ranga Lankathilaka
 */
@Entity
public class Warrenty {
    @Id
    private int wid;
    private String period;

    public Warrenty() {
    }

    public Warrenty(int wid, String period) {
        this.wid = wid;
        this.period = period;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Warrenty{" + "wid=" + wid + ", period=" + period + '}';
    }
    
    
    
    
}

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
public class WarrentyDTO {
     private int wid;
    private String period;

    public WarrentyDTO() {
    }

    public WarrentyDTO(int wid, String period) {
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
        return "WarrentyDTO{" + "wid=" + wid + ", period=" + period + '}';
    }
    
    
    
    
    
}

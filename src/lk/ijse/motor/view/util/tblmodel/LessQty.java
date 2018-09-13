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
public class LessQty {
    int pid;
    String pname;

    public LessQty(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    
    
}

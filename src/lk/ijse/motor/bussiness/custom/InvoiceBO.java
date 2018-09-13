/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom;

import lk.ijse.motor.bussiness.SuperBO;
import lk.ijse.motor.dto.InvoiceDTO;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface InvoiceBO extends SuperBO{
    
    public boolean save(InvoiceDTO entity) throws Exception;
    
    public int getLastIID() throws Exception;
    
}

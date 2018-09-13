/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom;

import lk.ijse.motor.bussiness.SuperBO;
import lk.ijse.motor.dto.InvoiceDetailDTO;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface InvoicedetailBO extends SuperBO{
    public boolean save(InvoiceDetailDTO entity) throws Exception;
    public boolean delete(Integer id,Integer pid) throws Exception;
    
}

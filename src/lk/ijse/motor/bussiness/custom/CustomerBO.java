/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom;

import java.util.ArrayList;
import lk.ijse.motor.bussiness.SuperBO;
import lk.ijse.motor.dto.CustomerDTO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.dto.InvoiceDetailDTO;
import lk.ijse.motor.dto.PartDTO;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface CustomerBO extends SuperBO{
    public boolean save(CustomerDTO dto,InvoiceDTO inv,ArrayList<InvoiceDetailDTO> arr,CustomerDetailDTO cusde,PartDTO part) throws Exception;
  //  customerBO.save(customerDTO, invoiceDTO, arrlist, customerDetailDTO, partDTO);
    
    public boolean save(CustomerDTO dto) throws Exception;
    
    public boolean delete(Integer cid) throws Exception;
    
    public ArrayList<CustomerDTO> getAll(CustomerDTO dto) throws Exception;
    
}

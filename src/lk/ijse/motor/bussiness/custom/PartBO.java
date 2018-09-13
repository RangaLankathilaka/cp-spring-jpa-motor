/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom;

import java.util.ArrayList;
import lk.ijse.motor.bussiness.SuperBO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.entity.Part;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface PartBO extends SuperBO{
    
    public boolean save(PartDTO dto) throws Exception;
    
    public boolean delete(Integer pid) throws Exception;
    
    public ArrayList<PartDTO> getAll() throws Exception;
    
    public ArrayList<PartDTO> getAllPartID()throws Exception;
    
    public PartDTO find(Integer pid) throws Exception;
    
    public boolean updateQty(PartDTO dto) throws Exception;
    
    public boolean update(PartDTO dto) throws Exception;
    
    public ArrayList<PartDTO> showQtyLessFive() throws Exception;
    
     public ArrayList<PartDTO> showSumQty() throws Exception;
     
  // public int getIncome() throws Exception;
    
    
}

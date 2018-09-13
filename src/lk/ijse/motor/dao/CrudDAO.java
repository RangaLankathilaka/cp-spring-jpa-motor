/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ranga Lankathilaka
 */
public interface CrudDAO<T,ID> extends SuperDao{
    
    public void save(T entity)throws Exception;
    
    public void update(T entity) throws Exception;
    
    public void delete(ID id) throws Exception;
    
    public T find(ID id) throws Exception;
    
    public List<T> getAll() throws Exception;
    
    
}

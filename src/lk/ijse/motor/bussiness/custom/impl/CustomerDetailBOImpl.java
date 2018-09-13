/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.CustomerDetailBO;

import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.entity.CustomerDetail;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ranga Lankathilaka
 */
@Component
public class CustomerDetailBOImpl implements CustomerDetailBO{
    @Autowired
    CustomerDetailDAO customerDetailDAO;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public CustomerDetailBOImpl() {
        
       // customerDetailDAO=(CustomerDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMERDETAIL);

    }
    
    
    
    

    @Override
    public boolean save(CustomerDetailDTO entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.



//            Customer customer = new Customer(dto.getCid(), dto.getCname(), dto.getContact(), dto.getAddress());
//            customerDAO.save(customer);


            CustomerDetail customerDetail=new CustomerDetail(null, entity.getCid(), entity.getPid());
            customerDetailDAO.save(customerDetail);
//        entityManager.getTransaction().commit();
//        entityManager.close();
            return true;



    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.InvoiceBO;

import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.Invoice;

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
public class InvoiceBOImpl implements InvoiceBO{
    @Autowired
    InvoiceDAO invoiceDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public InvoiceBOImpl() {
//        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.CUSTOMER);
//        invoiceDAO=(InvoiceDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICE);


    }
    

    @Override
    public boolean save(InvoiceDTO entity) throws Exception{
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // Invoice invoice=new Invoice(0,entity.getDiscription(),entity.getCid());

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//            invoiceDAO.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
            Customer customer = customerDAO.find(entity.getCid());
            System.out.println(">>>>>>>>>>>>>>>>>"+customer);
            Invoice invoice = new Invoice(getLastIID()+1,entity.getDiscription(),customer);
            invoiceDAO.save(invoice);

      //  entityManager.getTransaction().commit();
            return true;



    
    
    
    }

    @Override
    public int getLastIID() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Invoice lastIID = invoiceDAO.getLastIID();
//        int iid;
//
//         iid = lastIID.getIid();
//
//        return new InvoiceDTO(iid);

//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//            invoiceDAO.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();

//            int lastid = (int) entityManager.
//                    createNamedQuery("lastid").getFirstResult();
//
//           // System.out.println(lastid);
//
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
            return 0;








        }
    
    
    
}

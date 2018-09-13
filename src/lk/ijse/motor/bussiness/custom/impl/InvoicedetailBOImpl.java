/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import lk.ijse.motor.bussiness.custom.InvoicedetailBO;

import lk.ijse.motor.dao.custom.InvoiceDetailDAO;
import lk.ijse.motor.dto.InvoiceDetailDTO;
import lk.ijse.motor.entity.InvoiceDetail;
import lk.ijse.motor.entity.InvoiceDetail_PK;

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
public class InvoicedetailBOImpl implements InvoicedetailBO{
    @Autowired
    InvoiceDetailDAO invoiceDetailDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public InvoicedetailBOImpl() {
//        invoiceDetailDAO=(InvoiceDetailDAO) DAOFactory.getInstance().getDaotype(DAOFactory.Daotype.INVOICEDETAIL);
    //    entityManagerFactory = JPAUtil.getEntityManagerFactoryFactory();
    }

    @Override
    public boolean save(InvoiceDetailDTO entity) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
//    InvoiceDetail invoiceDetail=new InvoiceDetail(entity.getDetail(),entity.getQty(),entity.getSelling_price(), entity.getTotal(), entity.getTotal_amount(), entity.getIid(), entity.getPid());
//
//        return invoiceDetailDAO.save(invoiceDetail);
//

     //   EntityManager entityManager = entityManagerFactory.createEntityManager();

//            invoiceDetailDAO.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
            InvoiceDetail invoiceDetail=new InvoiceDetail(entity.getDetail(),entity.getQty(),entity.getSelling_price(), entity.getTotal(), entity.getTotal_amount(), entity.getIid(), entity.getPid());
            invoiceDetailDAO.save(invoiceDetail);

    //    entityManager.getTransaction().commit();
    //    entityManager.close();
            return true;






    }

    @Override
    public boolean delete(Integer id, Integer pid) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        InvoiceDetail_PK p=new InvoiceDetail_PK(id, pid);
    
//return invoiceDetailDAO.delete(p);


       // EntityManager entityManager = entityManagerFactory.createEntityManager();
         //   invoiceDetailDAO.setEntityManager(entityManager);
        //entityManager.getTransaction().begin();
            invoiceDetailDAO.delete(p);
        //entityManager.getTransaction().commit();
            return true;






    }

  

   
    
}

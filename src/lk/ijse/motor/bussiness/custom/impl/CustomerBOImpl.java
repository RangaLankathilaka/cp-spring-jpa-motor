/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.motor.bussiness.custom.CustomerBO;

import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.dao.custom.CustomerDetailDAO;
import lk.ijse.motor.dao.custom.InvoiceDAO;
import lk.ijse.motor.dao.custom.InvoiceDetailDAO;
import lk.ijse.motor.dao.custom.PartDAO;

import lk.ijse.motor.dto.CustomerDTO;
import lk.ijse.motor.dto.CustomerDetailDTO;
import lk.ijse.motor.dto.InvoiceDTO;
import lk.ijse.motor.dto.InvoiceDetailDTO;
import lk.ijse.motor.dto.PartDTO;
import lk.ijse.motor.entity.Customer;
import lk.ijse.motor.entity.CustomerDetail;
import lk.ijse.motor.entity.Invoice;
import lk.ijse.motor.entity.InvoiceDetail;
import lk.ijse.motor.entity.Part;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Ranga Lankathilaka
 */
@Component
public class CustomerBOImpl implements CustomerBO {
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    InvoiceDAO invoiceDAO;
    @Autowired
    InvoiceDetailDAO invoiceDetailDAO;
    @Autowired
    CustomerDetailDAO customerDetailDAO;
    @Autowired
    PartDAO partDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    public CustomerBOImpl() {


    }

//    @Override
//    public boolean save(CustomerDTO dto) throws Exception {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   
//    
//    }
    @Override
    public boolean delete(Integer cid) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//            customerDAO.setEntityManager(entityManager);
//            entityManager.getTransaction().begin();
            customerDAO.delete(cid);
          //  entityManager.getTransaction().commit();
            return true;

        
    }
    
    @Override
    public ArrayList<CustomerDTO> getAll(CustomerDTO dto) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//            customerDAO.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();

            List<Customer> allCustomers = customerDAO.getAll();

        //entityManager.getTransaction().commit();

            ArrayList<CustomerDTO> dtos = new ArrayList<>();

            for (Customer customer : allCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(customer.getCid(), customer.getCname(),customer.getContact(), customer.getAddress());
                dtos.add(customerDTO);
            }

            return dtos;
           }
    
    @Override
    public boolean save(CustomerDTO cus, InvoiceDTO inv, ArrayList<InvoiceDetailDTO> arr, CustomerDetailDTO cusde, PartDTO part) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Transaction transObj = null;

       // EntityManager entityManager = entityManagerFactory.createEntityManager();

//            customerDAO.setEntityManager(entityManager);
//            invoiceDAO.setEntityManager(entityManager);
//            invoiceDetailDAO.setEntityManager(entityManager);
//            customerDetailDAO.setEntityManager(entityManager);
//            partDAO.setEntityManager(entityManager);


    //    entityManager.getTransaction().begin();
        Customer customer = new Customer(cus.getCid(), cus.getCname(), cus.getContact(), cus.getAddress());
            customerDAO.save(customer);

            //Invoice invoice1 = invoiceDAO.find(inv.getCid());
            Customer customer1 = customerDAO.find(cus.getCid());
            Invoice invoice = new Invoice(inv.getIid(), inv.getDiscription(), customer1);//inv.getCid()
           invoiceDAO.save(invoice);


            InvoiceDetail invoiceDetail = null;

            for (InvoiceDetailDTO invoiceDetailDTO : arr) {
                int pid = invoiceDetailDTO.getPid();
                int iid = invoiceDetailDTO.getIid();
                String detail = invoiceDetailDTO.getDetail();
                int qty = invoiceDetailDTO.getQty();
                int selling_price = invoiceDetailDTO.getSelling_price();
                int total = invoiceDetailDTO.getTotal();
                int total_amount = invoiceDetailDTO.getTotal_amount();
                System.out.println("/////////////////////" + arr.size());
                invoiceDetail = new InvoiceDetail(detail, qty, selling_price, total, total_amount, iid, pid);
               invoiceDetailDAO.save(invoiceDetail);


            // Customer customer1=new Customer();

                Part part1 = new Part(part.getPid(), null, 0, 0, part.getQty(), null);
                System.out.println("----------------" + part.getQty());
               //partDAO.save(part1);



            }


            CustomerDetail customerDetail = new CustomerDetail(null, cusde.getCid(), cusde.getPid());

           customerDetailDAO.save(customerDetail);



//
//        entityManager.getTransaction().commit();
//        entityManager.close();
            return true;





            



    }

    @Override
    public boolean save(CustomerDTO dto) throws Exception {


//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//            customerDAO.setEntityManager(entityManager);
//        entityManager.getTransaction().begin();
            Customer customer = new Customer(dto.getCid(), dto.getCname(), dto.getContact(), dto.getAddress());
            customerDAO.save(customer);


       // entityManager.getTransaction().commit();
            return true;









    }
}

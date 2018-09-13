/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.ijse.motor.dao.CrudDAOImpl;

import lk.ijse.motor.dao.custom.CustomerDAO;
import lk.ijse.motor.entity.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 *
 * @author Ranga Lankathilaka
 */
@Component
public class CustomerDaoImpl extends CrudDAOImpl<Customer,Integer> implements CustomerDAO {



}

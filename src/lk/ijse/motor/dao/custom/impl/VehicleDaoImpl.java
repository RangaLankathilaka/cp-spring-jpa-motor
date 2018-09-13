/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.motor.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.motor.dao.CrudDAO;
import lk.ijse.motor.dao.CrudDAOImpl;

import lk.ijse.motor.dao.custom.VehecleDAO;
import lk.ijse.motor.entity.Vehicle;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ranga Lankathilaka
 */

@Component
public class VehicleDaoImpl extends CrudDAOImpl<Vehicle,Integer> implements VehecleDAO{


}

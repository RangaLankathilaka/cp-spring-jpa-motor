package lk.ijse.motor.dao.custom.impl;

import lk.ijse.motor.dao.custom.QueryDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryDAOImpl implements QueryDAO {
   @PersistenceContext
    private EntityManager entityManager;
}

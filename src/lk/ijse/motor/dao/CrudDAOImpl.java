package lk.ijse.motor.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class CrudDAOImpl<T,ID> implements CrudDAO<T,ID> {
    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> entity;

    public CrudDAOImpl() {
      //  entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entity = (Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    public void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public void save(T entity) throws Exception {
     // session.persist(entity);
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public void delete(ID id) throws Exception {
        T t = entityManager.find(entity, id);
        entityManager.remove(t);
    }

    @Override
    public T find(ID id) throws Exception {
       // return session.find(entity,id);
        return entityManager.find(entity, id);
    }

    @Override
    public List<T> getAll() throws Exception {
        //return session.createQuery("FROM"+entity.getName()).list();
        return entityManager.createQuery("FROM "+ entity.getName()).getResultList();



    }
}

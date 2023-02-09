package com.lawencon.demo.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BaseRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> T save(T entity){
        entityManager.persist(entity);

        return entity;
    }

    public <T> T update(T entity){
        return entityManager.merge(entity);
    }


    public <T> T findById(Class<T> clazz, String id){
        T objFind = null;

        try {
            objFind = entityManager.find(clazz,id);
        }catch (Exception e){

        }

        if(objFind != null){
            entityManager.detach(objFind);
        }

        return objFind;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> clazz, Integer page,Integer limit){
        StringBuilder hql = new StringBuilder();

        String className = clazz.getSimpleName();
        String classNameLower = className.toLowerCase();

        int first = (limit == null)? 0 : limit * (page - 1);

        hql.append("SELECT ")
                .append(classNameLower)
                .append(" ")
                .append("FROM ")
                .append(className).append(" ")
                .append(classNameLower);

        Query query = (page == null || limit == null)?
                entityManager.createQuery(hql.toString(),clazz):
                entityManager.createQuery(hql.toString(),clazz)
                        .setFirstResult(first)
                        .setMaxResults(limit);

        List<T> objs = query.getResultList();

        return objs;
    }

    public <T> Integer countOfData(Class<T> clazz){
        StringBuilder hql = new StringBuilder();

        String className = clazz.getSimpleName();
        String classNameLower = className.toLowerCase();

        hql.append("SELECT ")
                .append(classNameLower).append(" ")
                .append("FROM ")
                .append(className).append(" ")
                .append(classNameLower);

        Integer count = entityManager.createQuery(hql.toString(),clazz).getMaxResults();

        return count;
    }

    public <T> void delete(T entity){
        entityManager.remove(entity);
    }


}

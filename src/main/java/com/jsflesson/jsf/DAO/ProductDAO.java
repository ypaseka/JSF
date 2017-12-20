/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsflesson.jsf.DAO;

import com.jsflesson.jsf.entity.Product;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
@Model
public class ProductDAO{
    
    public List<Product>getProducts(){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsflesson");
       EntityManager em = emf.createEntityManager();
       
       List result = em.createNamedQuery("findAll").getResultList();
       
       em.close();
       emf.close();
       
       return result;
     
    }
    
    public void insert(Product p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsflesson");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void update(Product p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsflesson");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Product product = em.find(Product.class, p.getId());
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setCount(p.getCount());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void delete(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsflesson");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class,id);
        em.remove(product);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsflesson.jsf.service;

import com.jsflesson.jsf.DAO.ProductDAO;
import com.jsflesson.jsf.entity.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */

@Named
@RequestScoped
public class ProductService {
    
    @Inject
    ProductDAO service;
    
    public List<Product> get(){
        return  service.getProducts();
    }
    
    public void insert(Product p){
        service.insert(p);
    }
    
}

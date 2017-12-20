/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsflesson.jsf.services;

import com.jsflesson.jsf.DAO.ProductDAO;
import com.jsflesson.jsf.entity.Product;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named(value = "serviceController")
@RequestScoped
public class ProductService {
    
    @Inject
    private ProductDAO service;
    
    private Product product;
    
    @PostConstruct
    public void init(){
        product = new Product();
    }
    
    public List<Product> getAll(){
        return service.getProducts();
    }
    
    public void insert(){
        service.insert(product);
    }
    
    public String delete(Product p){
        service.delete(p.getId());
        return "index";
    }
    
    public void update(){
        service.update(product);
    }

    public Product getProduct() {
        return product;
    }
    
    public String addProduct(){
        return "add";
    }
    
    public String updateProduct(Product p){
        product = p;
        return "edit";
    }
    
    
}

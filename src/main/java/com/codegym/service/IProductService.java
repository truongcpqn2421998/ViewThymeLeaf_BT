package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void remove(int id);
    void update(int id,Product product);
    void save(Product product);
    List<Product> search(String name);
}

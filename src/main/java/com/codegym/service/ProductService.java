package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static final Map<Integer,Product> products;
    static{
        products=new HashMap<>();
        products.put(1,new Product(1,"tv",13213,"no comment"));
        products.put(2,new Product(2,"moto",12421,"no comment"));
        products.put(3,new Product(3,"laptop",34223,"no comment"));
        products.put(4,new Product(4,"watch",6554,"no comment"));
    }
    @Override
    public List<Product> findAll() {
        List<Product> productsList= new ArrayList<>(products.values());
        return productsList;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> all=findAll();
        List<Product> productList=new ArrayList<>();
        for (Product p:all
             ) {
            if(p.getName().equals(name)){
                productList.add(p);
            }
        }
        return productList;
    }
}

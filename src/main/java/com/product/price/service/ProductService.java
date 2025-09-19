package com.product.price.service;

import com.product.price.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

@Component
public class ProductService {
    public ProductService() {
    }

    Product product;
    HashMap<Integer, Product> hash = new HashMap<>();
    public void addProduct(Product product) {
        hash.put(product.getId(), product);
    }
    public ArrayList<Product> getProductsSortedByName() {
        ArrayList<Product> sortByName = new ArrayList<>(hash.values());
        Collections.sort(sortByName, (a, b) -> a.getName().compareTo(b.getName()));
        return sortByName;
    }
    public TreeSet<Product> getProductsSortedByPrice() {
        TreeSet<Product> sortByPrice = new TreeSet<>((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        for(int i : hash.keySet()) {
            sortByPrice.add(hash.get(i));
        }
        return sortByPrice;
    }
}

package com.enviro.assessment.grad001.andriesmatenjwa.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.dao.ProductRepository;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.Product;
@Service
public class ProductService {
     @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

     public List<Product> createProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

     public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
		return productRepository.findAll();
	}


}

package com.enviro.assessment.grad001.andriesmatenjwa.assessment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.Product;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.service.ProductService;
@RestController
public class ProductController {
     @Autowired
    public ProductService productService;
    @PostMapping("/addProduct")
    public Product Product(@RequestBody Product product){
         return productService.createProduct(product);
    }

     @GetMapping("/product/{id}")
     public Product getProductById(@PathVariable int id){
         return productService.getProductById(id);
    }

    @GetMapping("/products")
     public List<Product> getAllProducts(){
         return productService.getAllProducts();
    }
}

package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private  ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

}

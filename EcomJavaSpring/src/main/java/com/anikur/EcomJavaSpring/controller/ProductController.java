package com.anikur.EcomJavaSpring.controller;


import com.anikur.EcomJavaSpring.model.Product;
import com.anikur.EcomJavaSpring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add_product")
    public ResponseEntity<?> addProduct(@RequestPart("product") Product product, @RequestPart("image")MultipartFile image) throws IOException {
        return productService.addProduct(product, image);
    }

    @GetMapping("/allProduct")
    public ResponseEntity<List<Product>> fetchingAllProducts(){
        List<Product> allProducts = productService.fetchAllProduct();
        if(allProducts != null){
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("product/{productId}")
    public ResponseEntity<Product> fetchingAllProductsById(@PathVariable("productId") int Id){
        Product Products = productService.fetchAllProductById(Id);
        if(Products != null){
            return new ResponseEntity<>(Products, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> fetchingAllProductsByIdImage(@PathVariable("productId") int Id) throws IOException {
        Product products = productService.fetchAllProductByIdImage(Id);
        if(products == null || products.getImageData() == null){
            System.out.println("image not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            System.out.println("image data found");
            byte[] image = products.getImageData();
            return new ResponseEntity<>(image, HttpStatus.OK);
        }
    }
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestPart("product") Product product, @RequestPart("image")MultipartFile image) throws IOException {
        Product products = productService.fetchProductForUpdate(productId);
        if(products == null){
            System.out.println("update product not found");
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        else{
            System.out.println("the product is fetchfor the update");
           Product updateProduct =  productService.updateProudct(products, image);
            System.out.println("update porduct is: "+ updateProduct);
            return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        }
    }


    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam("productId") int productId){
        Product products = productService.fetchProductForDelete(productId);
        if (products == null){
            return new ResponseEntity<>("product is not found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
        }
    }
    @RequestMapping("/products/search")
    public ResponseEntity<List <Product>> keywordSearch(@RequestParam("keyword") String keyword){
        List<Product> allfindingProducts = productService.keywordSearchProduct(keyword);
        System.out.println("keyword is: " + keyword);
        if (allfindingProducts != null){
            return new ResponseEntity<>(allfindingProducts, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

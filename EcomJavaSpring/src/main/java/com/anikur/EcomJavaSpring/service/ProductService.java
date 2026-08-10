package com.anikur.EcomJavaSpring.service;

import com.anikur.EcomJavaSpring.model.Product;
import com.anikur.EcomJavaSpring.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public ResponseEntity<?> addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        try{
            return new ResponseEntity<>(productRepo.save(product), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Product> fetchAllProduct() {
        return productRepo.findAll();
    }


    public Product fetchAllProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }
    @Transactional
    public Product fetchAllProductByIdImage(int id) throws IOException {
        return productRepo.findById(id).orElse(null);
    }
    @Transactional
    public Product fetchProductForUpdate(int id) throws IOException {
        return productRepo.findById(id).orElse(null);
    }

    public Product updateProudct(Product products, MultipartFile image) throws IOException {
        products.setImageName(image.getOriginalFilename());
        products.setImageType(image.getContentType());
        products.setImageData(image.getBytes());
        return productRepo.save(products);
    }

    public Product fetchProductForDelete(int productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public String deleteProduct(int productId) {
        productRepo.deleteById(productId);
        return "product deleted successfully";
    }

    public List<Product> keywordSearchProduct(String keyword) {
        List<Product> keywordSearchProductResult = productRepo.keywordSearchProductResult(keyword);
        return keywordSearchProductResult;
    }
}

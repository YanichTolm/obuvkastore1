package com.example.obuvkastore.services;


import com.example.obuvkastore.entities.Category;
import com.example.obuvkastore.entities.Product;
import com.example.obuvkastore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.productRepository = repository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductByName(String name) {
        return getAllProducts().stream()
                .filter(product -> product.getNameProduct().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByCategory(Long idCategory) {
        return getAllProducts().stream()
                .filter(product -> product.getCategory().getId().equals(idCategory))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}

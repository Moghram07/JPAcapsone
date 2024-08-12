package com.example.capstone1.Service;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean updateProduct(Integer id, Product product) {
        Product p = productRepository.getById(id);

        if(p == null){
            return false;
        }
        p.setProductName(product.getProductName());
        p.setProductCategory(product.getProductCategory());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());

        productRepository.save(p);
        return true;
    }

    public boolean removeProduct(Integer id) {
        Product p = productRepository.getById(id);
        if(p == null){
            return false;
        }
        productRepository.delete(p);
        return true;
    }

    public Product getProductById(int id) {
        Product p = productRepository.getById(id);
        return p;
    }

}

package vn.Laptopshop.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.Laptopshop.laptopshop.domain.Product;
import vn.Laptopshop.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    public Product findProductById(long id) {
        return this.productRepository.findById(id);
    }
}

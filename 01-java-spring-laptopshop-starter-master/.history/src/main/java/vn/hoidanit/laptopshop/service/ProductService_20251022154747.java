package vn.Laptopshop.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.Laptopshop.laptopshop.domain.Product;
import vn.Laptopshop.laptopshop.repository.CartDetailRepository;
import vn.Laptopshop.laptopshop.repository.CartRepository;
import vn.Laptopshop.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository) {
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
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

    public void handleAddProductToCart() {

    }
}

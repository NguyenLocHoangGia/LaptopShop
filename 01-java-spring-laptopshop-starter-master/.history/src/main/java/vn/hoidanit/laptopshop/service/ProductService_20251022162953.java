package vn.Laptopshop.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.Laptopshop.laptopshop.domain.Cart;
import vn.Laptopshop.laptopshop.domain.CartDetail;
import vn.Laptopshop.laptopshop.domain.Product;
import vn.Laptopshop.laptopshop.domain.User;
import vn.Laptopshop.laptopshop.repository.CartDetailRepository;
import vn.Laptopshop.laptopshop.repository.CartRepository;
import vn.Laptopshop.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository, UserService userService) {
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.userService = userService;
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

    public void handleAddProductToCart(String email, long productId) {
        // check xem user có cart chưa? nếu chưa thì tạo
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setSum(1);

                cart = this.cartRepository.save(newCart);
            }
            Product foundProduct = this.productRepository.findById(productId);
            if (foundProduct != null) {
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setPrice(foundProduct.getPrice());
                cartDetail.setProduct(foundProduct);
                cartDetail.setQuantity(1);
                this.cartDetailRepository.save(cartDetail);
            }
        }
    }
}

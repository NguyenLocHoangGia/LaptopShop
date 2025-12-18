package vn.Laptopshop.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.Laptopshop.laptopshop.domain.Cart;
import vn.Laptopshop.laptopshop.domain.CartDetail;
import vn.Laptopshop.laptopshop.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    CartDetail findByCartAndProduct(Cart cart, Product product);
}

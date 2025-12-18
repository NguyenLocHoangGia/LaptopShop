package vn.Laptopshop.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vn.Laptopshop.laptopshop.domain.Product;
import vn.Laptopshop.laptopshop.service.ProductService;

@Controller
public class HomePageController {

    private final ProductService productService;

    public HomePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage() {

        List<Product> products = this.productService.getAllProducts();
        return "client/homepage/show";
    }

}

package vn.Laptopshop.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/admin/order")
    public String getOrderpage() {
        return "/admin/product/show";
    }

}

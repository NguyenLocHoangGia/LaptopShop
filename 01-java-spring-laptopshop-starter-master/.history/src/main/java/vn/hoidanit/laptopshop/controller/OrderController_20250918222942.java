package vn.Laptopshop.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping("/admin/order")
    public String getOrderPage() {
        return "/admin/order/show";
    }
}

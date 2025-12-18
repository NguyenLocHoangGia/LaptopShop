package vn.Laptopshop.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.Laptopshop.laptopshop.domain.Order;
import vn.Laptopshop.laptopshop.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderPage(Model model) {
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/details/{id}")
    public String getOrderPageDetail(Model model, @PathVariable long id) {
        Order order = this.orderService.findOrderById(id).get();
        model.addAttribute("order", order);
        model.addAttribute("id", id);
        return "admin/order/details";
    }

    @GetMapping("/admin/order/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("currentOrder", new Order());
        model.addAttribute("id", id);
        return "admin/order/deletePage";
    }

    @PostMapping("/admin/order/delete")
    public String postDeleteOrder(Model model, @ModelAttribute("newOrder") Order order) {
        this.orderService.deleteOrderById(order.getId());
        return "redirect:/admin/order";
    }

    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrder(Model model, @PathVariable long id) {
        Optional<Order> updateOrder = this.orderService.findOrderById(id);
        model.addAttribute("updateOrder", updateOrder.get());
        return "admin/order/updatePage";
    }

    @PostMapping("/admin/order/update")
    public String postUpdateOrder(@ModelAttribute("updateOrder") Order order) {
        this.orderService.updateOrder(order);
        return "redirect:/admin/order";
    }
}

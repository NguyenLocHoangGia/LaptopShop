package vn.Laptopshop.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.Laptopshop.laptopshop.domain.User;
import vn.Laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("Gia", test);
        return "hello";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public String userCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createPage";
    }
}

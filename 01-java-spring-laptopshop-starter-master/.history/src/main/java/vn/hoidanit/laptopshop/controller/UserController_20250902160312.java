package vn.Laptopshop.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.Laptopshop.laptopshop.domain.User;
import vn.Laptopshop.laptopshop.repository.UserRepository;
import vn.Laptopshop.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("Gia", test);
        return "hello";
    }

    @RequestMapping(value = "/admin/user")
    public String userCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createPage";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String userCreate(Model model, @ModelAttribute("newUser") User newUser) {
        System.out.println("run here" + newUser);
        this.userService.handleSaveUser(newUser);
        return "hello";
    }
}

package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUsersbyEmail("hoanggia09052004@gmail.com");
        System.out.println(arrUsers);
        model.addAttribute("Gia", "test");
        return "hello";
    }

    @RequestMapping(value = "/admin/user")
    public String userCreatePage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users1", users);
        return "admin/user/listUserPage";
    }

    @RequestMapping(value = "/admin/user/{id}")
    public String userDetailPage(Model model, @PathVariable long id) {
        System.out.println("check id user: " + id);
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/showDetail";
    }

    @RequestMapping(value = "/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createPage";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String userCreate(Model model, @ModelAttribute("newUser") User newUser) {
        System.out.println("run here" + newUser);
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/update";
    }

}

package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadFileService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadFileService uploadFileService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadFileService uploadFileService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadFileService = uploadFileService;
        this.passwordEncoder = passwordEncoder;
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

    @PostMapping(value = "/admin/user/create")
    public String userCreate(Model model, @ModelAttribute("newUser") User newUser,
            @RequestParam("avatarFile") MultipartFile file) {
        System.out.println("run here" + newUser);

        this.uploadFileService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(newUser.getPassword());
        // this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.findUserById(id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update/")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.findUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPassword(user.getPassword());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.findUserById(id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/deletePage";
    }

    @PostMapping("/admin/user/delete/")
    public String postDeleteUserPage(Model model, @ModelAttribute("newUser") User user) {
        System.out.println("run here");
        this.userService.deleteById(user.getId());
        return "redirect:/admin/user";
    }

}

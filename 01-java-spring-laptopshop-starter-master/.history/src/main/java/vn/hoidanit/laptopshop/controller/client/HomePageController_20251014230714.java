package vn.Laptopshop.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.Laptopshop.laptopshop.domain.Product;
import vn.Laptopshop.laptopshop.domain.User;
import vn.Laptopshop.laptopshop.domain.dto.RegisterDTO;
import vn.Laptopshop.laptopshop.service.ProductService;
import vn.Laptopshop.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    private final ProductService productService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public HomePageController(ProductService productService, PasswordEncoder passwordEncoder, UserService userService) {
        this.productService = productService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "/client/auth/register";
    }

    @PostMapping("/register")
    public String getRegisterPage(Model model,
            @ModelAttribute("registerUser") RegisterDTO registerDTO) {

        User user = this.userService.registerDTOtoUser(registerDTO);

        // String hashPassword = this.passwordEncoder.encode(user.getPassword());

        // user.setPassword(hashPassword);
        // user.setRole(this.userService.getRoleName("USER"));

        // this.userService.handleSaveUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "client/auth/login";
    }

}

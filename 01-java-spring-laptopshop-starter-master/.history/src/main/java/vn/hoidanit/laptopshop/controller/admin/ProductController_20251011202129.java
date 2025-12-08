package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadFileService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private ProductService productService;
    private final UploadFileService uploadFileService;

    public ProductController(ProductService productService, UploadFileService uploadFileService) {
        this.productService = productService;
        this.uploadFileService = uploadFileService;
    }

    @GetMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/showList";
    }

    @GetMapping("/admin/product/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/createProduct";
    }

    @PostMapping("/admin/product/create")
    public String postCreatePage(Model model,
            @ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult newProductBindingResult,
            @RequestParam("imgProduct") MultipartFile file) {

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>" + error.getField() + " - " + error.getDefaultMessage());
        }

        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/createProduct";
        }
        String imgProduct = this.uploadFileService.handleSaveUploadFile(file, "product");

        newProduct.setImage(imgProduct);
        this.productService.handleSaveProduct(newProduct);

        return "redirect:/admin/product ";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProduct(Model model, @PathVariable long id) {
        Product deleteProduct = this.productService.findProductById(id);
        model.addAttribute("deleteProduct", deleteProduct);
        return "/admin/product/deletePage";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("deleteProduct") Product product) {
        this.productService.deleteProductById(product.getId());
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        Product updateProduct = this.productService.findProductById(id);
        model.addAttribute("updateProduct", updateProduct);
        return "/admin/update/product";
    }

    @PostMapping("/admin/product/update")
    public String postUpdatePage(Model model, @ModelAttribute("updateProduct") Product product) {
        Product updateProduct = this.productService.findProductById(product.getId());
        if (updateProduct != null) {
            updateProduct.setName(updateProduct.getName());
            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

            updateProduct.setName(updateProduct.getName());

        }
        return "redirect:/admin/product";
    }

}

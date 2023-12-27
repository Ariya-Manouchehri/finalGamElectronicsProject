package ir.manouchehri.finalgamelectronicsproject.controller;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@Valid @RequestBody RequestProduct requestProduct){
        productService
    }
}

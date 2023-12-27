package ir.manouchehri.finalgamelectronicsproject.controller;

import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ProductDto addProduct(@Valid @RequestBody ProductDto requestProduct){
        return productService.addProduct(requestProduct);
    }
    
    @PutMapping("/updateProduct/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto requestProduct){
        return productService.updateProduct(id,requestProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/getProduct")
    public ProductDto getProduct(@RequestParam Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/getAllProduct")
    public List<ProductDto> getProduct(){
        return productService.getAllProducts();
    }
}

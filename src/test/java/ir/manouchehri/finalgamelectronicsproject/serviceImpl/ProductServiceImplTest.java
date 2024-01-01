package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.repository.ProductRepository;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {
    ProductServiceImpl productService;
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImplTest(ProductServiceImpl productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Test
    void addProduct() {
        int productSize = productRepository.findAll().size();
        ProductDto productDto = new ProductDto();
        productDto.setName("pofak");
        productDto.setPrice(14.500);
        productService.addProduct(productDto);
        assertEquals(productRepository.findAll().size(), productSize + 1);
    }

    @Test
    void updateProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setName("chips");
        productDto.setPrice(17.500);
        ProductDto productDtoResult = productService.updateProduct(1L,productDto);
        assertNotNull(productDtoResult);
    }

    @Test
    void deleteProduct() {
        int sizeProduct = productRepository.findAll().size();
        productService.deleteProduct(1L);
        assertEquals(productRepository.findAll().size(), sizeProduct - 1);
    }
}
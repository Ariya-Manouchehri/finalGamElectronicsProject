package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto requestProduct);

    ProductDto updateProduct(Long id, ProductDto requestProduct);

    void deleteProduct(Long id);

    ProductDto getProduct(Long id);

    List<ProductDto> getAllProducts();
}

package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;

import java.util.List;

public interface ProductService {
    RequestProduct addProduct(RequestProduct requestProduct);

    RequestProduct updateProduct(Long id,RequestProduct requestProduct);

    void deleteProduct(Long id);

    RequestProduct getProduct(Long id);

    List<RequestProduct> getAllProduct();
}

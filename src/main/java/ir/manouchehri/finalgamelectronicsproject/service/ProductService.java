package ir.manouchehri.finalgamelectronicsproject.service;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;

public interface ProductService {
    Product addProduct(RequestProduct requestProduct);
}

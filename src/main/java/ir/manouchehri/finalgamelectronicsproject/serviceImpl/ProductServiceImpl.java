package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;
import ir.manouchehri.finalgamelectronicsproject.repository.ProductRepository;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(RequestProduct requestProduct) {
        productRepository.save(requestProduct);
    }
}

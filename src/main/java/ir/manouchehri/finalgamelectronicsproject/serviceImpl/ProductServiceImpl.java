package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;
import ir.manouchehri.finalgamelectronicsproject.mapper.ProductDtoMapper;
import ir.manouchehri.finalgamelectronicsproject.repository.ProductRepository;
import ir.manouchehri.finalgamelectronicsproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductDtoMapper productDtoMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,ProductDtoMapper productDtoMapper) {
        this.productRepository = productRepository;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public RequestProduct addProduct(RequestProduct requestProduct) {
        Product product = productRepository.save(productDtoMapper.RequestProductToProduct(requestProduct));
        return productDtoMapper.ProductToRequestProduct(product);
    }

    @Override
    public RequestProduct updateProduct(Long id, RequestProduct requestProduct) {
        Optional<Product> product = productRepository.findById(id);
        product.get().setName(requestProduct.getName());
        product.get().setPrice(requestProduct.getPrice());
        return productDtoMapper.ProductToRequestProduct(productRepository.save(product.get()));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public RequestProduct getProduct(Long id) {
        return productDtoMapper.ProductToRequestProduct(productRepository.findById(id).get());
    }

    @Override
    public List<RequestProduct> getAllProduct() {
        return productDtoMapper.listOfProductToListOfRequestProduct(productRepository.findAll());
    }
}

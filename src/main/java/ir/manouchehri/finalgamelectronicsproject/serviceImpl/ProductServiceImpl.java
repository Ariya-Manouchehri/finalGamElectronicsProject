package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
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
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productRepository.save(productDtoMapper.productDtoToProduct(productDto));
        return productDtoMapper.productToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto requestProduct) {
        Optional<Product> product = productRepository.findById(id);
        product.get().setName(requestProduct.getName());
        product.get().setPrice(requestProduct.getPrice());
        return productDtoMapper.productToProductDto(productRepository.save(product.get()));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return productDtoMapper.productToProductDto(productRepository.findById(id).get());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDtoMapper.listOfProductToListOfProductDto(productRepository.findAll());
    }
}

package ir.manouchehri.finalgamelectronicsproject.serviceImpl;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException.AddProductException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException.DeleteProductException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException.FindProductException;
import ir.manouchehri.finalgamelectronicsproject.exceptions.ProductException.UpdateProductException;
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
    public ProductServiceImpl(ProductRepository productRepository, ProductDtoMapper productDtoMapper) {
        this.productRepository = productRepository;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        try {
            Product product = productRepository.save(productDtoMapper.productDtoToProduct(productDto));
            return productDtoMapper.productToProductDto(product);
        } catch (Exception e) {
            throw new AddProductException();
        }
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto requestProduct) {
        try {
            Optional<Product> product = productRepository.findById(id);
            product.get().setName(requestProduct.getName());
            product.get().setPrice(requestProduct.getPrice());
            return productDtoMapper.productToProductDto(productRepository.save(product.get()));
        } catch (Exception e) {
            throw new UpdateProductException();
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            if (product.isEmpty()) {
                throw new DeleteProductException();
            }
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteProductException();
        }
    }

    @Override
    public ProductDto getProduct(Long id) {
        try {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new FindProductException();
        }
        return productDtoMapper.productToProductDto(product.get());
        }catch (Exception e){
            throw new FindProductException();
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productDtoMapper.listOfProductToListOfProductDto(productRepository.findAll());
    }
}

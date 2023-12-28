package ir.manouchehri.finalgamelectronicsproject.mapper;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product productDtoToProduct(ProductDto requestProduct);

    ProductDto productToProductDto(Product product);

    List<ProductDto> listOfProductToListOfProductDto(List<Product> products);

    List<Product> listOfProductDtoToListOfProduct(List<ProductDto> productsDto);

}

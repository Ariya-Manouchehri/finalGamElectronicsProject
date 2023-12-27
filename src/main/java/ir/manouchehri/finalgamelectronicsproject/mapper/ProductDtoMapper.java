package ir.manouchehri.finalgamelectronicsproject.mapper;

import ir.manouchehri.finalgamelectronicsproject.domain.Product;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product RequestProductToProduct(RequestProduct requestProduct);

    RequestProduct ProductToRequestProduct(Product product);

    List<RequestProduct> listOfProductToListOfRequestProduct(List<Product> products);
}

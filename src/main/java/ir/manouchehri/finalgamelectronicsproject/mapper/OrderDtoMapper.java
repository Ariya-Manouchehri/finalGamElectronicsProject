package ir.manouchehri.finalgamelectronicsproject.mapper;

import ir.manouchehri.finalgamelectronicsproject.domain.Order;
import ir.manouchehri.finalgamelectronicsproject.dto.request.RequestOrderDto;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import ir.manouchehri.finalgamelectronicsproject.dto.response.ResponseOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDto.class, ProductDto.class})
public interface OrderDtoMapper {

    @Mapping(source ="userDto", target ="user")
    @Mapping(source = "productsDto",target = "products")
    Order orderDtoToOrder(ResponseOrderDto orderDto);

    @Mapping(source ="user", target ="userDto")
    @Mapping(source = "products",target = "productsDto")
    ResponseOrderDto orderToOrderDto(Order order);

    @Mapping(source ="userDto", target ="user")
    @Mapping(source = "productsDto",target = "products")
    List<ResponseOrderDto> listOfOrderToListOfOrderDto(List<Order> orders);
}

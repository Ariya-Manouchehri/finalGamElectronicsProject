package ir.manouchehri.finalgamelectronicsproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {

    private Double totalPrice;

    private UserDto userDto;

    private List<ProductDto> productsDto;
}

package ir.manouchehri.finalgamelectronicsproject.dto.response;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import ir.manouchehri.finalgamelectronicsproject.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseOrderDto {
    private Double totalPrice;

    private UserDto userDto;

    private List<ProductDto> productsDto;
}

package ir.manouchehri.finalgamelectronicsproject.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestOrderDto {

    private Double totalPrice;

    private Long userId;

    private List<Long> productsId;
}

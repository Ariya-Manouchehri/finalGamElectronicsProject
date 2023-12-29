package ir.manouchehri.finalgamelectronicsproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    //@Pattern(regexp = "\\d{5}-\\w$")
    @NotNull
    private String name;

    @NotNull
    private Double price;
}

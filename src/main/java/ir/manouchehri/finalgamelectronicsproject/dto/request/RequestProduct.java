package ir.manouchehri.finalgamelectronicsproject.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestProduct {

    //@Pattern(regexp = "\\d{5}-\\w")
    @NotNull
    private String name;

    @NotNull
    private Double price;
}

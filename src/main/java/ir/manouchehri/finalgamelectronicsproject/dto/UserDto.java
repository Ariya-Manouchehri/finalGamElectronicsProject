package ir.manouchehri.finalgamelectronicsproject.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class UserDto {
    @NotNull
    @Pattern(regexp = "[0][9]\\d{9}")
    private String mobilePhone;

    @NotNull
    @Pattern(regexp = "^[^<>%@+$|='\"]*$")
    private String password;
}

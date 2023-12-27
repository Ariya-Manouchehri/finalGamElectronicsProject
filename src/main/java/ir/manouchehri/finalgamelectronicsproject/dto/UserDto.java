package ir.manouchehri.finalgamelectronicsproject.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class UserDto {
    private Long mobilePhone;

    private Long password;
}

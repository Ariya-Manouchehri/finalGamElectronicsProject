package ir.manouchehri.finalgamelectronicsproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @CreationTimestamp
    @Column(name = "create_data_time", updatable = false)
    private LocalDateTime createDataTime;

    @UpdateTimestamp
    @Column(name = "update_data_time")
    private LocalDateTime updateDataTime;
}

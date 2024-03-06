package io.miwurster.clean.adapter.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductSchema extends Schema {

    private String name;

    private String description;

    @Column(scale = 15, precision = 30)
    private BigDecimal price;

    @CreatedDate
    private LocalDateTime createdAt;
}

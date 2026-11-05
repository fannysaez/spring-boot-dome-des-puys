package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String label;
    private String description;
    private BigDecimal price;
    private String slug;
    private LocalDateTime createdAt;
    private Long brandId;
}
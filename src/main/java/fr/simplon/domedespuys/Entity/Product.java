package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.ProductView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductView.Id.class)
    private Long id;

    @Column(nullable = false, length = 150)
    @JsonView(ProductView.Label.class)
    private String label;

    @Column(columnDefinition = "TEXT")
    @JsonView(ProductView.Description.class)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    @JsonView(ProductView.Price.class)
    private BigDecimal price;

    @Column(nullable = false, unique = true, length = 150)
    @JsonView(ProductView.Slug.class)
    private String slug;

    @Column(nullable = false, updatable = false)
    @JsonView(ProductView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonView(ProductView.Images.class)
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonView(ProductView.OrderProducts.class)
    private List<OrderProduct> orderProducts = new ArrayList<>();
}
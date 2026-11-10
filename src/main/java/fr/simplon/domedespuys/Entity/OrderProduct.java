package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.OrderProductView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(OrderProductView.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(OrderProductView.Quantity.class)
    private int quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    @JsonView(OrderProductView.Price.class)
    private BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "purchase_id", nullable = false)
    @JsonView(OrderProductView.Purchase.class)
    private Purchase purchase;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonView(OrderProductView.Product.class)
    private Product product;
}
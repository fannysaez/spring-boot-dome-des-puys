package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.PurchaseView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseView.Id.class)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    @JsonView(PurchaseView.Number.class)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @JsonView(PurchaseView.Status.class)
    private EnumPurchaseStatus status = EnumPurchaseStatus.PENDING;

    @Column(nullable = false, updatable = false)
    @JsonView(PurchaseView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @JsonView(PurchaseView.Address.class)
    private Address address;

    @OneToMany(mappedBy = "purchase")
    @JsonView(PurchaseView.OrderProducts.class)
    private List<OrderProduct> orderProducts = new ArrayList<>();
}
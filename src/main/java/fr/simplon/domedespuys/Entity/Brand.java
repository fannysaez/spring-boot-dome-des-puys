package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.BrandView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BrandView.Id.class)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    @JsonView(BrandView.Label.class)
    private String label;

    @Column(length = 255)
    @JsonView(BrandView.Logo.class)
    private String logo;

    @Column(nullable = false, unique = true, length = 150)
    @JsonView(BrandView.Slug.class)
    private String slug;

    @OneToMany(mappedBy = "brand")
    @JsonView(BrandView.Products.class)
    private List<Product> products = new ArrayList<>();
}
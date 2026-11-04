package fr.simplon.domedespuys.Entity;

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
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String label;

    @Column(length = 255)
    private String logo;

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
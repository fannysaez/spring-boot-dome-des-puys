package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.ImageView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ImageView.Id.class)
    private Long id;

    @Column(nullable = false, length = 255)
    @JsonView(ImageView.Path.class)
    private String path;

    @Column(nullable = false, length = 10)
    @JsonView(ImageView.Extension.class)
    private String extension;

    @Column(nullable = false)
    @JsonView(ImageView.IsDefault.class)
    private boolean isDefault;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
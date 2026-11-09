package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.AddressView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AddressView.Id.class)
    private Long id;

    @Column(nullable = false, length = 255)
    @JsonView(AddressView.Line.class)
    private String line;

    @Column(length = 255)
    @JsonView(AddressView.ExtraLine.class)
    private String extraLine;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.City.class)
    private String city;

    @Column(nullable = false, length = 20)
    @JsonView(AddressView.ZipCode.class)
    private String zipCode;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Country.class)
    private String country;

    @Column(length = 30)
    @JsonView(AddressView.Phone.class)
    private String phone;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Lastname.class)
    private String lastname;

    @Column(nullable = false, updatable = false)
    @JsonView(AddressView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
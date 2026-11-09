package fr.simplon.domedespuys.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Views.UserView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Id.class)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    @JsonView(UserView.Email.class)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 100)
    @JsonView(UserView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 100)
    @JsonView(UserView.Lastname.class)
    private String lastname;

    @Column(length = 30)
    @JsonView(UserView.Phone.class)
    private String phone;

    @Column(nullable = false, length = 50)
    @JsonView(UserView.Role.class)
    private String role;

    @Column(nullable = false, updatable = false)
    @JsonView(UserView.CreatedAt.class)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Addresses.class)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Purchases.class)
    private List<Purchase> purchases = new ArrayList<>();
}
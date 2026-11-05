package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String role;
    private LocalDateTime createdAt;
}
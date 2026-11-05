package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String line;
    private String extraLine;
    private String city;
    private String zipCode;
    private String country;
    private String phone;
    private String firstname;
    private String lastname;
    private LocalDateTime createdAt;
    private Long userId;
}
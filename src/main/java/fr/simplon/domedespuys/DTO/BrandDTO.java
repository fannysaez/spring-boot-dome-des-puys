package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class BrandDTO {

    private Long id;
    private String label;
    private String slug;
    private String logo;
}
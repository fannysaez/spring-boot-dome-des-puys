package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {

    private Long id;
    private String path;
    private String extension;
    private boolean isDefault;
    private Long productId;
}
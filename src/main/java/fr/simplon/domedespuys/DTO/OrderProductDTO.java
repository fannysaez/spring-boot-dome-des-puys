package fr.simplon.domedespuys.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductDTO {

    private Long id;
    private int quantity;
    private int price;
    private Long purchaseId;
    private Long productId;
}
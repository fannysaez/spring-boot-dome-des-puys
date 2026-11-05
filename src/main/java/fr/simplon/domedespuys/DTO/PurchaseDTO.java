package fr.simplon.domedespuys.DTO;

import fr.simplon.domedespuys.Entity.EnumPurchaseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseDTO {

    private Long id;
    private String number;
    private EnumPurchaseStatus status;
    private LocalDateTime createdAt;
    private Long userId;
    private Long addressId;
}
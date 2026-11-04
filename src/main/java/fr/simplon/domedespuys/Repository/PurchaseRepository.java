package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}

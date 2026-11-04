package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
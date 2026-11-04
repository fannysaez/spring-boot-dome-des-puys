package fr.simplon.domedespuys.Repository;

import fr.simplon.domedespuys.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
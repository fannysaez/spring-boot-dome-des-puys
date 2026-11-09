package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.UserRepository;
import fr.simplon.domedespuys.Views.UserView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @JsonView(UserView.UserListView.class)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'id " + id));
    }
}
package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.UserRepository;
import fr.simplon.domedespuys.Service.Interfaces.IUserService;
import fr.simplon.domedespuys.Views.UserView;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;
    private IUserService userService;

    public UserController(UserRepository userRepository, IUserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    @JsonView(UserView.UserListView.class)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @JsonView(UserView.UserDetailView.class)
    public User createUser(@RequestBody UserPostDTO dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User updateUser(@PathVariable String id, @RequestBody UserPutDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }
}
package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Service.Interfaces.IUserService;
import fr.simplon.domedespuys.Views.UserView;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(UserView.UserDetailView.class)
    public User createUser(@Valid @RequestBody UserPostDTO dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public User updateUser(@PathVariable String id, @Valid @RequestBody UserPutDTO dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }
}
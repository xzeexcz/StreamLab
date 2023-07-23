package kz.bitlab.streamlab.restControllers;

import kz.bitlab.streamlab.dto.UserDTO;
import kz.bitlab.streamlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserDTO> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{userId}")
    public UserDTO oneUser(@PathVariable(name = "userId") String userId) {
        return userService.oneUser(userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/{userId}/roles")
    public ResponseEntity<?> updateUserRole(@PathVariable(name = "userId") String userId, @RequestBody List<String> roles){
        return userService.updateUser(userId,roles);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{userId}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "userId") String userId) {
        return userService.deleteUser(userId);
    }
}

package kz.bitlab.streamlab.restControllers;

import kz.bitlab.streamlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/reset")
@RequiredArgsConstructor
public class ResetPasswordController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<String> checkUser(@RequestParam(name = "userEmail")String email) {
        System.out.println(email);
       return userService.checkUser(email);
    }
    @PutMapping()
    public ResponseEntity<String> changePassword(@RequestParam(name = "user_old_password") String oldPassword,
                                                 @RequestParam(name = "user_new_password") String newPassword,
                                                 @RequestParam(name = "user_email") String email) {
        return userService.updatePassword(newPassword,oldPassword,email);
    }

}

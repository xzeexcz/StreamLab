package kz.bitlab.streamlab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RecoverPassController {
    @GetMapping(value = "/recover-password")
    public String recoverPass() {
        return "recover-password";
    }
}

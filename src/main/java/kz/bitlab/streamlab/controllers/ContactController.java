package kz.bitlab.streamlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping(value = "/contact-us")
    public String contact() {
        return "contact-us";
    }
}

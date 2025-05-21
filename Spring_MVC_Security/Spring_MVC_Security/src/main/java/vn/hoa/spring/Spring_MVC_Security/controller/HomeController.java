package vn.hoa.spring.Spring_MVC_Security.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping
    public String showHomePage(Model model) {
        return "home";
    }
}

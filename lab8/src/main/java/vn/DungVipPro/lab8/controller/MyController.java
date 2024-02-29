package vn.DungVipPro.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MyController {
    @GetMapping("/index")
    public String index(Principal principal, Model model){
        return "home/index";
    }
}

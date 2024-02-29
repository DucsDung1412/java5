package vn.DungVipPro.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/index")
    public String index(){
        return "This is index";
    }

    @GetMapping("/user")
    public String user(){
        return "This is user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is admin";
    }
}

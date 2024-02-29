package vn.DungVipPro.lab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.DungVipPro.lab7.model.MailInfo;

@Controller
public class PageController {
    @GetMapping("/mail")
    public String index(Model model){
        MailInfo mailInfo = new MailInfo();
        model.addAttribute("mailInfo", mailInfo);
        return "/index";
    }
}

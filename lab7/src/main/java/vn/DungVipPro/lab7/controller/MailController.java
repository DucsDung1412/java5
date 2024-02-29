package vn.DungVipPro.lab7.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.DungVipPro.lab7.mail.MailerServiceImpl;
import vn.DungVipPro.lab7.mail.SendMailInteface;
import vn.DungVipPro.lab7.model.MailInfo;

import java.io.File;
import java.util.ArrayList;

@RestController
public class MailController {
    private SendMailInteface mailService;

    @Autowired
    public MailController(@Qualifier("mailerServiceImpl") MailerServiceImpl mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/mailer/demo")
    public String demo(@ModelAttribute("mailInfo") MailInfo mailInfo) {
        try {
            this.mailService.queue(mailInfo.getTo(), mailInfo.getSubject(), mailInfo.getBody());
//            this.mailService.send("zekoxpop@gmail.com", "Subject", "Body");
            return "OK";
        } catch (MessagingException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/mailer/demo1")
    public String demo1(@ModelAttribute("mailInfo") MailInfo mail, @RequestParam("Cc") String cc, @RequestParam("Bcc") String bcc, @RequestParam("file") File file) {
        String[] arrayCc = cc.split(",");
        String[] arrayBcc = bcc.split(",");
        mail.setCc(arrayCc);
        mail.setBcc(arrayBcc);
        String[] attachments = {file.getAbsolutePath()};
        mail.setAttachments(attachments);
        mail.setFrom("nguyenhoahung1007@gmail.com");
        this.mailService.queue(mail);
        return "OK";
//        try {
//            this.mailService.send(mail);
//            return "OK";
//        } catch (MessagingException e) {
//            return e.getMessage();
//        }
    }
}

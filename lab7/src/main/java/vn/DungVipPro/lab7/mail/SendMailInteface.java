package vn.DungVipPro.lab7.mail;

import jakarta.mail.MessagingException;
import vn.DungVipPro.lab7.model.MailInfo;

public interface SendMailInteface {
    void send(MailInfo mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void queue(MailInfo mail);

    void queue(String to, String subject, String body) throws MessagingException;
}

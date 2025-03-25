package com.course.belajar_spring;

import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private Session session;

    public EmailService(Session session) {
        super();
        this.session = session;
    }

    public void sendMail() throws Exception {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@example.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("to@example.com"));
        message.setSubject("Mail Subject");
        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Email sent successfully");
    }
}

package com.course.belajar_spring;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailService {
    private Session session;

    public EmailService(Session session) {
        super();
        this.session = session;
    }

    public void sendMail() throws Exception {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("fromtest@course.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("totest@course.com"));
        message.setSubject("Hello word set subject email");
        message.setText("Enjoy sending emails from Jakarta Mail!");
        Transport.send(message);
        System.out.println("Email Message Sent Successfully!");
    }
}

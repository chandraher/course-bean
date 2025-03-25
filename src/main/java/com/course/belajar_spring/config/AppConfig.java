package com.course.belajar_spring.config;

import com.course.belajar_spring.Author;
import com.course.belajar_spring.Book;
import com.course.belajar_spring.EmailService;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@ComponentScan(basePackages = { "com.couse.belajar_spring" })
@Configuration
public class AppConfig {
    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);

        author.setName("Chandra Hermawan");

        return author;
    };

    @Bean
    public Book book1(@Qualifier("author1") Author author) {
        Book book = new Book("Who is book", author);
        return book;
    }

    @Bean
    public Properties mailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "500");

        return prop;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("388483462761431", "sjdgah23461f4g14");
    }

    @Bean
    public Session mailSession(
            @Qualifier("mailProperties") Properties mailProperties,
            PasswordAuthentication authentication) {

        Session session = Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
        return session;
    }

     @Bean
     public EmailService emailService(@Qualifier("mailSession") Session
     mailSession) {
     return new EmailService(mailSession);
     }
}

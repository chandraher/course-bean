package com.course.belajar_spring;

import com.course.belajar_spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService = (EmailService) appContext.getBean("emailService");

        try {
            emailService.sendMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

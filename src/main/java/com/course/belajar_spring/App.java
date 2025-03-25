package com.course.belajar_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        EmailService emailService = (EmailService) ctx.getBean("emailService");

        try {
            emailService.sendMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

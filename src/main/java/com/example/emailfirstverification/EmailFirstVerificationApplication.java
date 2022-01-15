package com.example.emailfirstverification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailFirstVerificationApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmailFirstVerificationApplication.class, args);
    }


    //    private final EmailSenderService service;
//
//    @Autowired
//    public EmailFirstVerificationApplication(EmailSenderService service) {
//        this.service = service;
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail() throws MessagingException {
//        service.sendSimpleEmail("lanre.olowo@yahoo.com",
//                "This is the email body",
//                "This is the email subject");
//
//        service.sendEmailWithAttachment("lanre.olowo@yahoo.com",
//                "This is the email body with attachment",
//                "This is the email subject",
//                "/Users/mac/Desktop/DP.jpeg");
//    }




}

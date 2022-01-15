package com.example.emailfirstverification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleEmail(String toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("lanre.olowo@yahoo.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        System.out.println("Mail Send....");
    }


    public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        mimeMessageHelper.setFrom("lanre.olowo@yahoo.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystem.getFilename()), fileSystem);

        javaMailSender.send(mimeMailMessage);
        System.out.println("Mime Mail send.....");
    }
}

package com.example.mail_sender_project;

import com.example.mail_sender_project.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        System.out.println("Sending email");
        emailService.sendEmail("depressedmillennial53@gmail.com", "Subject", "Message");
    }

    @Test
    void sendEmailWithHtml(){
        String html = ""+
                "<h1 style='color:red;border:1px solid red;'>Welcome to Spring boot</h1>" +
                "";
        emailService.sendEmailWithHtml("depressedmillennial53@gmail.com", "Subject", html);
    }

    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("depressedmillennial53@gmail.com",
                "subject",
                "This email contains file",
                new File("C:\\Users\\Shrijit Das\\Pictures\\Screenshots\\Screenshot 2023-11-07 010512.png"));
    }

    @Test
    void sendEmailWithFileWithStream(){
        File file = new File("C:\\Users\\Shrijit Das\\Pictures\\Screenshots\\Screenshot (3).png");
        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("depressedmillennial53@gmail.com",
                    "Email with file",
                    "This email contains file",
                    is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

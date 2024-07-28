package com.example.mail_sender_project.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //Send email to single person
    void sendEmail(String recipient, String subject, String message);

    //send email to multiple people
    void sendEmail(String []recipients, String subject, String message);

    //send email with HTML
    void sendEmailWithHtml(String recipient, String subject, String message);

    //send email with file
    void sendEmailWithFile(String recipient, String subject, String message, File file);

    void sendEmailWithFile(String recipient, String subject, String message, InputStream is);
}

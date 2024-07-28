package com.example.mail_sender_project.apis;

import com.example.mail_sender_project.helper.CustomResponseEntity;
import com.example.mail_sender_project.models.EmailRequest;
import com.example.mail_sender_project.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmailWithHtml(request.getRecipient(), request.getSubject(), request.getMessage());
        return ResponseEntity.ok(
                CustomResponseEntity.builder().message("Email sent successfully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<?> sendEmailWithFile(@RequestPart EmailRequest request, @RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(request.getRecipient(), request.getSubject(), request.getMessage(), file.getInputStream());
        return ResponseEntity.ok(
                CustomResponseEntity.builder().message("Email sent successfully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }
}

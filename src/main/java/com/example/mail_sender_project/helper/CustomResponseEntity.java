package com.example.mail_sender_project.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomResponseEntity {
    private String message;
    private HttpStatus httpStatus;
    private boolean success = false;

}

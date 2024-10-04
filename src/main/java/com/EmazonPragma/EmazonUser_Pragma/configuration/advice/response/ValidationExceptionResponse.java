package com.EmazonPragma.EmazonUser_Pragma.configuration.advice.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionResponse {
    private Integer statusCode;
    private HttpStatusCode status;
    private String message;
    private LocalDateTime timeStamp;
    private List<String> errors;
}

package com.EmazonPragma.EmazonUser_Pragma.configuration.advice.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Integer statusCode;
    private HttpStatusCode status;
    private String message;
    private LocalDateTime timeStamp;
}

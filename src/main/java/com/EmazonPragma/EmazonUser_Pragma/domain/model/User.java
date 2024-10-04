package com.EmazonPragma.EmazonUser_Pragma.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String lastName;
    private String numberDocument;
    private LocalDateTime birthDate;
    private String numberPhone;
    private String email;
    private String password;
    private Role role;
}

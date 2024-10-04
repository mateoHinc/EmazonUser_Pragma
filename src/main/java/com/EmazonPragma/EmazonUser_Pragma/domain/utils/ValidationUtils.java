package com.EmazonPragma.EmazonUser_Pragma.domain.utils;

import com.EmazonPragma.EmazonUser_Pragma.domain.exceptions.UnderAgeException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class ValidationUtils {
    public ValidationUtils() {
        throw new IllegalStateException("Utility Class");
    }
    public static void validateBirthDate(LocalDateTime birthDate) {
        if(birthDate.until(LocalDateTime.now(), ChronoUnit.YEARS) < 18) throw new UnderAgeException();
    }
}

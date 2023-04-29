package com.geekster.validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long userId;
    @NotBlank(message = "Username cannot be blank")
    private String userName;
    @NotNull(message = "Date of birth cannot be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth must be in yyyy-MM-dd format")
    private String dateOfBirth;
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @Pattern(regexp = "\\d{12}", message = "Phone number must be 12 digits with country code")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;
    @Past
    private LocalDate date;
    private LocalTime time;





}

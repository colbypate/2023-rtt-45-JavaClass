package com.teksytems.capstone.formbeans;

import org.hibernate.validator.constraints.Length;

import com.teksytems.capstone.validation.EmailUnique;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFormBean {
    private Integer id;
    @NotEmpty(message="First name is required.")
    @Length(max=40, message="First Name cannot be longer than 40 characters.")
    private String firstName;
    @NotEmpty(message="Last name is required.")
    private String lastName;
    @NotEmpty(message="Email address is required.")
    @Length(max=30, message="Email cannot be longer than 30 characters.")
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid email format.")
    @EmailUnique(message="Email already exists in database.")
    private String email;
    private String job;

    @NotEmpty(message = "Password is required.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$])[A-Za-z\\d!@#$]{8,}$", message = "Invalid password format")
    private String password;

    @NotEmpty(message = "Confirming password is required.")
    private String confirmPassword;
}

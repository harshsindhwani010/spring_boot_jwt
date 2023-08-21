package com.example.spring_boot_jwt.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}

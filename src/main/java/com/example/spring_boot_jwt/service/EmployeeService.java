package com.example.spring_boot_jwt.service;

import com.example.spring_boot_jwt.dto.ChangePasswordDTO;
import com.example.spring_boot_jwt.dto.LoginDTO;
import com.example.spring_boot_jwt.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    String saveUser(EmployeeEntity userEntity);
    List<EmployeeEntity> getAllUser();
    EmployeeEntity getUserDetails(String userName);
    List<EmployeeEntity> getUserDetailsNameAndEmail(String userName, String email);
    ResponseEntity<Object> authenticateUser(LoginDTO loginDTO);
    ResponseEntity<Object> changePassword(String username, ChangePasswordDTO changePasswordDTO);

}

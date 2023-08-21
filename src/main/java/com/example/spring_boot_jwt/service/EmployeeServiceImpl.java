package com.example.spring_boot_jwt.service;

import com.example.spring_boot_jwt.dto.*;
import com.example.spring_boot_jwt.entity.EmployeeEntity;
import com.example.spring_boot_jwt.repository.EmployeeRepository;
import com.example.spring_boot_jwt.security.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JWTUtility jwtUtility;

    @Override
    public String saveUser(EmployeeEntity userEntity) {
        EmployeeEntity userEntity1 = employeeRepository.save(userEntity);
        return "success";
    }

    @Override
    public List<EmployeeEntity> getAllUser() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getUserDetails(String userName) {
        return employeeRepository.findByUserName(userName);
    }

    @Override
    public List<EmployeeEntity> getUserDetailsNameAndEmail(String userName, String email) {
        return employeeRepository.findByUserNameOrEmailIgnoreCase(userName, email);
    }

    @Override
    public ResponseEntity<Object> authenticateUser(LoginDTO loginDTO) {
        EmployeeEntity employee = getUserDetails(loginDTO.getUserName());
        if(employee!=null) {
            if(employee.getPassword().equals(loginDTO.getPassword())) {
                HashMap<String, String> data = new HashMap<>();
                data.put("username", employee.getUserName());
                data.put("email", employee.getEmail());
                ArrayList<AppUserRole> roles = new ArrayList<>();
                roles.add(AppUserRole.ROLE_ADMIN);
                String token = jwtUtility.createToken(employee.getUserName(), roles, data);
                TokenResponse response = new TokenResponse();
                response.setToken(token);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Invalid credentials!", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("User Not found!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> changePassword(String username, ChangePasswordDTO changePasswordDTO) {
        ResponseDTO response = new ResponseDTO();
        if (changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword())) {

            EmployeeEntity employee = employeeRepository.findByUserName(username);
            if (employee == null) {
                response.setMessage("Invalid Token!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                if (employee.getPassword().equals(changePasswordDTO.getOldPassword())) {
                    employee.setPassword(changePasswordDTO.getNewPassword());
                    employeeRepository.save(employee);
                    response.setMessage("Password changed successfully!");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Incorrect old password!");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            response.setMessage("New and confirm password different!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

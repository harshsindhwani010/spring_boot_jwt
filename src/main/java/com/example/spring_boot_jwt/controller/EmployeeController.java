package com.example.spring_boot_jwt.controller;

import com.example.spring_boot_jwt.dto.ChangePasswordDTO;
import com.example.spring_boot_jwt.dto.LoginDTO;
import com.example.spring_boot_jwt.entity.EmployeeEntity;
import com.example.spring_boot_jwt.repository.EmployeeRepository;
import com.example.spring_boot_jwt.security.JWTUtility;
import com.example.spring_boot_jwt.service.EmployeeService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTUtility jwtUtility;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/userLogin")
    public ResponseEntity<Object> userLogin(@RequestBody LoginDTO loginDTO) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAutheninsertOtpticationToken(
//                            loginDTO.getUserName(),
//                            loginDTO.getPassword()
//                    )
//            );
//        } catch (BadCredentialsException e) {
//            ResponseDTO response = new ResponseDTO();
//            response.setMessage("INVALID CREDENTIALS");
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        return userService.authenticateUser(loginDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody EmployeeEntity userEntity) {
        List<EmployeeEntity> employee = userService.getUserDetailsNameAndEmail(userEntity.getUserName(), userEntity.getEmail());
        if (employee.size() > 0) {
            return new ResponseEntity<>("User Name or email Already Exists!!", HttpStatus.BAD_REQUEST);
        }
        String msg = userService.saveUser(userEntity);
        if (msg.equalsIgnoreCase("success")) {
            return new ResponseEntity<>("User Registered SuccessFully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed!", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUser(@RequestHeader("Authorization") String bearerToken) {
        System.out.println("hello");
        bearerToken = bearerToken.substring(7, bearerToken.length());
        Claims claims = jwtUtility.getAllClaimsFromToken(bearerToken);
        String username = claims.get("username").toString();
        EmployeeEntity employee = userService.getUserDetails(username);
        if (employee != null) {
            return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @RequestHeader("Authorization") String bearerToken) {
        bearerToken = bearerToken.substring(7, bearerToken.length());
        Claims claims = jwtUtility.getAllClaimsFromToken(bearerToken);
        String username = claims.get("username").toString();
        return userService.changePassword(username, changePasswordDTO);
    }
}

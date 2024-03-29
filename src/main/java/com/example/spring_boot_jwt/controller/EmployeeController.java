package com.example.spring_boot_jwt.controller;

import com.example.spring_boot_jwt.dto.ChangePasswordDTO;
import com.example.spring_boot_jwt.dto.LoginDTO;
import com.example.spring_boot_jwt.dto.ResponseDTO;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        ResponseDTO response = new ResponseDTO();
        if (!validateEmail(userEntity.getEmail())) {
            response.setMessage("Invalid Email!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else if (!checkUserName(userEntity.getUserName())) {
            response.setMessage("Invalid User Name!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            List<EmployeeEntity> employee = userService.getUserDetailsNameAndEmail(userEntity.getUserName(), userEntity.getEmail());
            if (employee.size() > 0) {
                response.setMessage("User Name or email Already Exists!!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            String msg = userService.saveUser(userEntity);
            if (msg.equalsIgnoreCase("success")) {
                response.setMessage("User Registered Successfully!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed!", HttpStatus.BAD_REQUEST);

            }
        }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<Object> getAllUser(@RequestHeader("Authorization") String bearerToken) {
        ResponseDTO response = new ResponseDTO();
        bearerToken = bearerToken.substring(7, bearerToken.length());
        Claims claims = jwtUtility.getAllClaimsFromToken(bearerToken);
        String username = claims.get("username").toString();
        EmployeeEntity employee = userService.getUserDetails(username);
        if (employee != null) {
            return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
        } else {
            response.setMessage("Invalid Token!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @RequestHeader("Authorization") String bearerToken) {
        bearerToken = bearerToken.substring(7, bearerToken.length());
        Claims claims = jwtUtility.getAllClaimsFromToken(bearerToken);
        String username = claims.get("username").toString();
        return userService.changePassword(username, changePasswordDTO);
    }

    public static boolean validateEmail(String email) {
       // String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        //Pattern pattern = Pattern.compile(regex);
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
        Matcher matcher = pattern.matcher(email);
        System.out.println(matcher.matches());
        return matcher.matches();
    }

    public static boolean checkUserName(String name) {
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        System.out.println(matcher.matches());
        return matcher.matches();
    }
}

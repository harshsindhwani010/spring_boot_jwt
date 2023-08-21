package com.example.spring_boot_jwt.service;

import com.example.spring_boot_jwt.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements IUserService {
    @Autowired
    EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        EmployeeEntity user = employeeService.getUserDetails(userName);
        if(user==null){
            throw new UsernameNotFoundException("User not found:"+ userName);
        }
        return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}

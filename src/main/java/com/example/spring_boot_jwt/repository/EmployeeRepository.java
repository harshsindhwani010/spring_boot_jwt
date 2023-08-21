package com.example.spring_boot_jwt.repository;

import com.example.spring_boot_jwt.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findByUserName(String userName);

    List<EmployeeEntity> findByUserNameOrEmailIgnoreCase(String userName, String email);
}

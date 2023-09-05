package com.example.spring_boot_jwt.repository;


import com.example.spring_boot_jwt.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}


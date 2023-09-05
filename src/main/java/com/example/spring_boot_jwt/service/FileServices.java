package com.example.spring_boot_jwt.service;

import com.example.spring_boot_jwt.entity.FileData;

import java.util.List;
import java.util.Optional;

public interface FileServices {
    Optional<FileData> getFileDayById(Long id);
    byte[] generateFileContent(String formData);
    FileData saveFormData(FileData fd);
    List<FileData> getAllFile();
}

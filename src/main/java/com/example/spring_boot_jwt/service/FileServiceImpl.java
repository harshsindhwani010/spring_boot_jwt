package com.example.spring_boot_jwt.service;

import java.util.List;
import java.util.Optional;

import com.example.spring_boot_jwt.entity.FileData;
import com.example.spring_boot_jwt.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl implements FileServices{

	    @Autowired
	    private FileDataRepository fileDataRepository;
	    
	    public Optional<FileData> getFileDayById(Long id) {
	    	return fileDataRepository.findById(id);
	    }

	    public byte[] generateFileContent(String formData) {
	        // Generate your file content here
	        return formData.getBytes();
	    }

	    public FileData saveFormData(FileData fd) {
	      //  FileData fileData = new FileData(formData);
	        return fileDataRepository.save(fd);
	    }
	    
	    public List<FileData> getAllFile(){
	    	return fileDataRepository.findAll();
	    }
	}


package com.example.spring_boot_jwt.controller;

import com.example.spring_boot_jwt.entity.FileData;
import com.example.spring_boot_jwt.service.FileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.Optional;


@Controller
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    FileServices fileService;

    @GetMapping(value = "/edit")
    public String editForm(Model model) {
        System.out.println("hello");
        return "EditForm";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        FileData fileInfo = new FileData();
        try {
            fileInfo.setFileName(file.getOriginalFilename());
            fileInfo.setFileType(file.getContentType());
            fileInfo.setFormData(file.getBytes());
            fileService.saveFormData(fileInfo);

            return "redirect:/edit?success"; // Redirect back to the edit page with a success message
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred");
            return "edit"; // Return to the edit page with an error message
        }
    }

    @GetMapping(value = "/download")
    public String fileDownloadGet(Model model) {
        model.addAttribute("fileLists", fileService.getAllFile());
        return "Download";
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<Object> downloadFile(@PathVariable Long id) throws MalformedURLException {
        Optional<FileData> fileData = fileService.getFileDayById(id);
        if (fileData.isPresent()) {
            FileData fileInfo = fileData.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileInfo.getFileName() + "\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(fileInfo.getFormData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
	
	



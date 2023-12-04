package com.dehradun.UplNDwnld.Controller;

import com.dehradun.UplNDwnld.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private StorageService storageService;
    @PostMapping
    public ResponseEntity<?> uploadMyFile(@RequestParam("file")MultipartFile file) throws IOException {
        String uploadFile=storageService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadFile);
    }
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
        byte[] filedata = storageService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("application/pdf"))
                .body(filedata);

    }
}

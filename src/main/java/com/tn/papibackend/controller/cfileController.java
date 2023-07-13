package com.tn.papibackend.controller;


import com.tn.papibackend.payload.MessageResponse;
import com.tn.papibackend.service.ICfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/cfile")
@AllArgsConstructor
public class cfileController {

    private ICfileService fileService;

    @PostMapping("/uploadFile/{id}")
    public ResponseEntity<MessageResponse> upload(@RequestParam("files") List<MultipartFile> files, @PathVariable Long id) {
        MessageResponse message =    fileService.uploadFile(files,id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}

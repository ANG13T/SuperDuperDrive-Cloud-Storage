package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    UserService userService;
    FileService fileService;

    public FileController(UserService userService, FileService fileService){
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping
    public String uploadFile(@RequestParam("fileUpload") MultipartFile fileUpload, Model model){
        BufferedReader br;
        List<String> result = new ArrayList<>();

        try{

            InputStream fis = fileUpload.getInputStream();
            String currentUserName = "";


            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                currentUserName = authentication.getName();
            }


            Integer userID = userService.getUser(currentUserName).getUserId();
            File uploadFile = new File(fileUpload.getName(), fileUpload.getContentType(), fileUpload.getOriginalFilename(), userID, fileUpload.getBytes());
            System.out.println(uploadFile);
            this.fileService.setFile(uploadFile);
        }catch(IOException exception){
            System.out.println("Something went wrong");
        }
        return "redirect:/home?q=File+created!";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String handleDeleteNote(@PathVariable String id) {
        System.out.println(id);
        System.out.println("deleting file");
        this.fileService.deleteFile(Long.parseLong(id));
        return "redirect:/home";
    }

    @RequestMapping(value = "{id}/view", method = RequestMethod.GET)
    public ResponseEntity<Resource> handleViewFile(@PathVariable String id) {
        System.out.println(id);
        System.out.println("deleting file");
        File selectedFile = this.fileService.getFile(Long.parseLong(id));
        ByteArrayResource resource = new ByteArrayResource(selectedFile.getFiledata());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}

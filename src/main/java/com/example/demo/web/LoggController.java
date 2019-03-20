package com.example.demo.web;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StorageService;
import com.example.demo.metier.FileImplementation;

@Controller
public class LoggController{
@Autowired
private FileImplementation fileImplementation;
private final StorageService storageService;

@Autowired
public LoggController(StorageService storageService) {
    this.storageService = storageService;
}

@GetMapping("/")
public String listUploadedFiles(Model model) throws IOException {



    return "uploadForm";
}
	
}

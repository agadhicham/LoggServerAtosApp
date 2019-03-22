package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.payload.UploadFileResponse;
import com.example.demo.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
 * Création d'un API REST pour le telechargement de fichier ou des pulusieurs fichiers 
 * ainsi que la récuperation du fichier télecharger
 * */

@RestController
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	String fileName = fileStorageService.storeFile(file);
        /*
         * ServeleUriComponentsBuilder:envirenement de servelete constructeur par defaut , prepare l'objet a instencier 
    	 * et prepare la demande de client avec plein de valeur tel port ...
    	 */
    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                // concatener tous les composant de url afin d'avoir un url en chaîne de cartactéres seulment
                .toUriString();
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    
    

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    	// la methode asList() charge le tablesu files de type MultipartFile afin de le convertir en liste
    	return Arrays.asList(files)
    			// manipulation des données qu'elles provient du tableau multipartfile
                .stream()
                //map(): permet de choisir uniquement ce qu'on veut parcourir
                 .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    
    
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        //loadFileAsResource() recupere le fichier enregestrer d'apeés le dossier uploads
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        
        // determisation de type de fichier s'agit d'un image/png jpg ou application/pdf xord....
        String contentType = null;
        
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("le type de ce fichier n'est pas determiner.");
        }

        // retour avec un default type de fichier
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    

}

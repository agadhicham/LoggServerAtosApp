package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.DBFileRepository;
import com.example.demo.model.DBFile;

import java.io.IOException;

/**
 * @author A752328
 *
 */
/**
 * @author A752328
 *
 */
@Service
public class DBFileStorageService {

	
    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new com.example.demo.exception.FileStorageException("Attention ! Format de fichier voulu n'existe pas !!" + fileName);
            }
            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new com.example.demo.exception.FileStorageException("Le fichier sur nom n'est pas enregestrer" + fileName + ".veuillez esseyer!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId).get();
    }
}
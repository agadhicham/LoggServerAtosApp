//package com.example.demo.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.exception.FileStorageException;
//import com.example.demo.exception.MyFileNotFoundException;
//import com.example.demo.property.FileStorageProperties;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
///*
// * Le service de création de systeme de storage des fichier et de les récuperer
// */
//@Service
//public class FileStorageService {
//	private final Path fileStorageLocation;
//
//	@Autowired
//	public FileStorageService(FileStorageProperties fileStorageProperties) {
//		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
//
//		try {
//			// Création de fichier declarer dans le fichier application.properties
//			Files.createDirectories(this.fileStorageLocation);
//		} catch (Exception ex) {
//			// dans le cas d'echec de creation de fichier "uploads"
//			throw new FileStorageException("le fichier >>uploads<<  ne peut pas être crer.", ex);
//		}
//	}
//
//	// enregestrement de fichier choisir
//	public String storeFile(MultipartFile file) {
//		/**
//		 * normalisation de fichier prenons le chemain de fichier ensuite en le
//		 * visualiser afin de retourner just son origine nom
//		 */
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//		try {
//			// verefication si le fichier choisir contient des caracteres non valide
//			// si il contient par exemple NOMX..jpg nomy..txt sera refusé
//			if (fileName.contains("..")) {
//				throw new FileStorageException(
//						"Pardon! Le nom de fichier contient une séquence de chemin invalide " + fileName);
//			}
//
//			// envoyer et enregestrer le fichier dans le dossier 'même nom == remplacer'
//			// la methode RESOLVE() a role de remplacer un par autre
//			Path targetLocation = this.fileStorageLocation.resolve(fileName);
//			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//			return fileName;
//		} catch (IOException ex) {
//			throw new FileStorageException(
//					"votr fichier n'est pas enregestrer " + fileName + ". ressayer une autre fois!", ex);
//		}
//	}
//
//	//Extraction de fichier enregestrer 
//	public Resource loadFileAsResource(String fileName) {
//		try {
//			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
//			Resource resource = new UrlResource(filePath.toUri());
//			if (resource.exists()) {
//				return resource;
//			} else {
//				throw new MyFileNotFoundException("fichier n'existe pas !!" + fileName);
//			}
//		} catch (MalformedURLException ex) {
//			throw new MyFileNotFoundException("fichier n'existe pas !!" + fileName, ex);
//		}
//	}
//}

package com.example.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;

import com.example.demo.controller.FileController;
import com.example.demo.controller.JavaReadFileToString;
import com.example.demo.dao.DBFileRepository;
import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.metier.FileImplementation;
import com.example.demo.model.DBFile;
import com.example.demo.property.FileStorageProperties;
import com.example.demo.service.CategorieService;

@SpringBootApplication
//pour activer la laison entre la class pojo et le fichier application.properties
@EnableConfigurationProperties({ FileStorageProperties.class })
public class AppLog1Application implements CommandLineRunner {

	@Autowired
	private FileController fileController;
	
	/**
	 * 
	 */
	@Autowired
	private CategorieService categorieService;

	@Autowired
	private FileImplementation fileImplementation;
	@Autowired
	private DBFileRepository dbFileRepository;
	
	
	
	public static void main(String[] args) {
	
		SpringApplication.run(AppLog1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		
		
		// TODO Auto-generated method stub
//		categorieService.saveServerCategorie(new ServerCategorie(null, "Jboss", null));
//		categorieService.saveServerCategorie(new ServerCategorie(null, "Apache", null));
//		categorieService.saveServerCategorie(new ServerCategorie(null, "Tomcate", null));

// ServerCategorie categorie =new ServerCategorie(null, "serverjboss2");
//		// System.out.println(categorie.getNomCategorie());
//		System.out.println("**************************************************************");
//		ServerCategorie serverCategorie = new ServerCategorie(null, "ServerCateg2", null);
//		categorieService.saveServerCategorie(serverCategorie);

		System.out.println("===================="); 
		System.out.println("La liste des categories");
		System.out.println(categorieService.getAllCat().toString());
		System.out.println("====================");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		File file = new File(null, "fileAA", null, null, serverCategorie);
//		fileImplementation.saveFile(file);
		System.out.println(fileImplementation.findAllFiles().toString());
		System.out.println("////////////////////////////");
		//System.out.println(this.fileController.getFilesByCtat(new DBFile().getId()));

//		
//		DBFile dbFile= new DBFile(null, "gggg", null, null, new ServerCategorie(null, "tttt", null));
//		this.dbFileRepository.saveAndFlush(dbFile);
//		
//		ServerCategorie serverCategorie = new ServerCategorie(null, "serveurJbs", null);
//		this.categorieService.saveServerCategorie(serverCategorie);
		
	}

}

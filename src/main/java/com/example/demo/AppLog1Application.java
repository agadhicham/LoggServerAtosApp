package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;

import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.metier.FileImplementation;
import com.example.demo.property.FileStorageProperties;
import com.example.demo.service.CategorieService;

@SpringBootApplication

//pour activer la laison entre la class pojo et le fichier application.properties
@EnableConfigurationProperties({ FileStorageProperties.class })
public class AppLog1Application implements CommandLineRunner {

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private FileImplementation fileImplementation;

	public static void main(String[] args) {
		SpringApplication.run(AppLog1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		categorieService.saveServerCategorie(new ServerCategorie(null, "Jboss"));
		categorieService.saveServerCategorie(new ServerCategorie(null, "Apache"));
		categorieService.saveServerCategorie(new ServerCategorie(null, "Tomcate"));

		// ServerCategorie categorie =new ServerCategorie(null, "serverjboss2");
		// System.out.println(categorie.getNomCategorie());
		System.out.println("**************************************************************");
		ServerCategorie serverCategorie = new ServerCategorie(null, "ServerCateg2");
		categorieService.saveServerCategorie(serverCategorie);

		System.out.println("====================");
		System.out.println("La liste des categories");
		System.out.println(categorieService.getAllCat().toString());
		System.out.println("====================");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		File file = new File(null, "fileAA", null, null, serverCategorie);
		fileImplementation.saveFile(file);
		System.out.println(fileImplementation.findAllFiles().toString());

	}

}

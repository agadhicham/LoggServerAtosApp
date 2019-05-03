package com.example.demo.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfece.ServreTomcatTrining;
import com.example.demo.model.DBFile;

@Service
public class TomcatServerServiceTrining implements ServreTomcatTrining {

	@Autowired
	private DBFileStorageService dBFileStorageService;

	private String serverName = "";
	private Long occurenceOfKey = null;

	@Override
	public String tomcatFiltrageToGetServer(String fieldId) {
		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
		String fileChar = new String(dbFile.getData());
		if (fileChar.contains("INFO: The APR based Apache Tomcat")) {
			this.serverName = "Tomcat_Server";
		} else if (fileChar.contains("INFO: Initializing")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("INFO: Démarrage du service Catalina")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("INFO: Starting Servlet Engine:")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("INFO: Déploiement")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("INFO: TLD skipped.")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("INFO: Cookies: Invalid cookie.")) {
			this.serverName = "Tomcat_Server";
		}

		else if (fileChar.contains("GET /")) {
			this.serverName = "Tomcat_Server";
		}

		return serverName;
	}

	@Override
	public String tomcatFiltrageToGetEstimation(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] tomcatFiltrageToGetDate(String fieldId) {
 
		DBFile dbFile= this.dBFileStorageService.getFile(fieldId);
		String getFileContent = new String(dbFile.getData());
		  String[] splitArray = null; //tableau de chaînes
		  //la chaîne à traiter
		  String str = new String (dbFile.getData());
		  // On découpe la chaîne "str" à traiter et on récupère le résultat dans le tableau "splitArray"
		  splitArray = str.split(" ");
		  for(int i = 0; i< splitArray.length;i++){
		   // On affiche chaque élément du tableau
		   System.out.println("élement n° " + i + "=[" + splitArray[3]+"]");
		   System.out.println("-+-+-+-+---+-");
		   System.out.println(splitArray[splitArray.length-1]);
		   System.out.println("-+-+-+-+---+-");
		  }

		return splitArray;
	}

	@Override
	public Long tomcatFiltrageToGetOccurence(String fieldId) {
		DBFile dbFile= this.dBFileStorageService.getFile(fieldId);
		String getFileContent = new String(dbFile.getData());
		  String[] splitArray = null; //tableau de chaînes
		  //la chaîne à traiter
		  String str = new String (dbFile.getData());
		  // On découpe la chaîne "str" à traiter et on récupère le résultat dans le tableau "splitArray"
		  splitArray = str.split(" ");
		  for(int i = 0; i< splitArray.length;i++){
		   // On affiche chaque élément du tableau
			  
		   System.out.println("élement n° " + i + "=[" + splitArray[3]+"]");
		   System.out.println("-+-+-+-+---+-");
		   System.out.println(splitArray[splitArray.length-1]);
		   System.out.println("-+-+-+-+---+-");
		  }
		return null;
	}

}

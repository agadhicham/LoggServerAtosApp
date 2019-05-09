package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfece.ServreTomcatTrining;
import com.example.demo.model.DBFile;

@Service
public class TomcatServerServiceTrining implements ServreTomcatTrining {

	@Autowired
	private DBFileStorageService dBFileStorageService;

	private String serverName = "";
	private Long occurenceOfKey = null;
	private String totalOccurence = null;
	String total = "";

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

		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
		new String(dbFile.getData());
		String[] splitArray = null; 
		String str = new String(dbFile.getData());
		splitArray = str.split(" ");
//			for (int i = 0; i < splitArray.length; i++) {
//				System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
//				this.tot = splitArray[splitArray.length - 1];
//			
//		}
//			if (str.contains("GET")) {
//				for (int i = 0; i < splitArray.length; i++) {
//				// On affiche chaque élément du tableau
//				System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
//				this.total = splitArray[splitArray.length - 1];
//				// System.out.println(splitArray[splitArray.length-1]);
//			}
//		
//		}
		//this.totalOccurence = splitArray[splitArray.length - 1];
		System.out.println("+-+-+-+-+-+-");
		System.out.println(totalOccurence);
		System.out.println("+-+-+-+-+-+-");
		System.out.println(total);

		return splitArray;
	}

	@Override
	public Long tomcatFiltrageToGetOccurence(String fieldId) throws IOException{
		System.out.println("total des occurences");
//		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
//		new String(dbFile.getData());
//		// tableau de chaînes sur la condition num 1
//		String[] splitArray = null;
//		// la chaîne à traiter
//		String str = new String(dbFile.getData());
//		// On découpe la chaîne "str" à traiter et on récupère le résultat dans le tableau "splitArray"
//		splitArray = str.split(" ");
//		for (int i = 0; i < splitArray.length; i++) {
//			this.totalOccurence = splitArray[splitArray.length - 1];
//		}
//		System.out.println("+-+-+-+-+-+-");
//		System.out.println(totalOccurence);
//		System.out.println("+-+-+-+-+-+-");
//		return Long.parseLong(totalOccurence);
		
		//DBFile dbFile= this.dBFileStorageService.getFile(fieldId);
		  String[] words=null;  
	      FileReader fr = new FileReader("java taba java");  
	      BufferedReader br = new BufferedReader(fr); 
	      String s;     
	      String input="Java";   
	      Long count= null;   
	      while((s=br.readLine())!=null)   
	      {
	         words=s.split(" ");  
	          for (String word : words) 
	          {
	                 if (word.equals(input))   
	                 {
	                   count++;    
	                 }
	          }
	      }
	      if(count!=0)  
	      {
	         System.out.println("The given word is present for "+count+ " Times in the file");
	      }
	      else
	      {
	         System.out.println("The given word is not present in the file");
	      }
	      
	         fr.close();
	   
		return count;
		
	}

}

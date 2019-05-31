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
	private String total = "";
    private String wordSearshe="";
	
	
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
			for (int i = 0; i < splitArray.length; i++) {
				//System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
			//	this.tot = splitArray[splitArray.length - 1];
			
		}
			if (str.contains("GET")) {
				for (int i = 0; i < splitArray.length; i++) {
				// On affiche chaque élément du tableau
				System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
				this.total = splitArray[splitArray.length - 1];
				 System.out.println(this.total);
			}
		
		}
		 this.totalOccurence = splitArray[splitArray.length - 1];
		System.out.println("+-+-+-+-+-+-");
		System.out.println(totalOccurence);
		System.out.println("+-+-+-+-+-+-");
//		System.out.println(total);

		return splitArray;
	}

	@Override
	public String tomcatFiltrageToGetOccurence(String fieldId, String motCle) throws IOException {
	DBFile dbFile= this.dBFileStorageService.getFile(fieldId);
	String contentInFile = new String(dbFile.getData());
	
	 String strArray[] = contentInFile.split("\\n");
     int t=0;
	 for (int i = 0; i < strArray.length; i++) {
		//System.out.println(strArray[i]);
		if (contentInFile.contains(motCle)) {
			t=strArray.length;
		}
	}
	 System.err.println("total="+t);
	 
	if (contentInFile.contains(motCle))
	{
	 System.out.println("yeep i find it !!!!");
	 System.err.println(strArray.length);
	}
	  int count =0;
      //byte[] bytesArray = new byte[(int)contentInFile.length()];
      //fis.read(bytesArray);
      String s = new String(dbFile.getData());
      String [] data = s.split(" ");
      for (int i=0; i<data.length; i++) {
         count++;
      }
      System.out.println("Number of characters in the given file are " +count);
	//System.out.println(contentInFile);
			return contentInFile;

	}

}

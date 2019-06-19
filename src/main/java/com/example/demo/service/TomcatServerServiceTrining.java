package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfece.ServreTomcatTrining;
import com.example.demo.model.DBFile;

import lombok.extern.slf4j.Slf4j;

@Service
@CrossOrigin(origins = "*")
@Slf4j
public class TomcatServerServiceTrining implements ServreTomcatTrining {

	@Autowired
	private DBFileStorageService dBFileStorageService;

	private String serverName = "";
	private Long occurenceOfKey = null;
	private String totalOccurence = null;
	private int total = 0;
	private String wordSearshe = "";

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
		String[] splitArray1 = null;

		String str = new String(dbFile.getData());
		splitArray = str.split("WebServices");
		for (int i = 0; i < splitArray.length; i++) {
			// System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
			// this.tot = splitArray[splitArray.length - 1];

		}
		if (str.contains("WebServices")) {
			for (int i = 0; i < splitArray.length; i++) {
				// On affiche chaque élément du tableau
				System.out.println("élement n° " + i + "=[" + splitArray[5] + "]");
				this.total = i;
				System.out.println("-+-+-+-+-+-+-+-" + this.total);
//				this.total = splitArray[splitArray.length - 1];
//				 System.out.println(this.total);
			}

		}
		return splitArray;
	}

	@Override
	public int tomcatFiltrageToGetOccurence(String fieldId) throws IOException {
		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
		new String(dbFile.getData());
		String[] splitArray = null;
		String[] splitArray1 = null;

		String str = new String(dbFile.getData());
		splitArray = str.split("impression/ajouter");
		for (int i = 0; i < splitArray.length; i++) {
			// System.out.println("élement n° " + i + "=[" + splitArray[3] + "]");
			// this.tot = splitArray[splitArray.length - 1];
		}
		if (str.contains("impression/ajouter")) {
			splitArray1 = str.split(" ");
			for (int i = 0; i < splitArray1.length; i++) {
				System.out.println("*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("=[" + splitArray1[3] + "]");
				System.out.println("*/*/*/*/*/*/*/*/*/*/*/*");
				// this.tot = splitArray[splitArray.length - 1];
			}
		}
		if (str.contains("impression/ajouter")) {
			for (int i = 0; i < splitArray.length; i++) {
				// On affiche chaque élément du tableau
				// System.out.println("élement n° " + i + "=[" + splitArray[5] + "]");
				this.total = i;
				System.out.println("-+-+-+-+-+-+-+-" + this.total);
//				this.total = splitArray[splitArray.length - 1];
//				 System.out.println(this.total);
			}
		}
		return this.total;

	}

	@Override
	public String tomcatFiltrageToGetDateFormat(String fieldId) {
		DBFile dbFile = this.dBFileStorageService.getFile(fieldId);
		new String(dbFile.getData());
		String[] splitArray = null;
		String[] splitArray1 = null;
		String str = new String(dbFile.getData());
		splitArray1 = str.split(" ");
		splitArray = str.split("impression/ajouter");
		//if (str.contains("impression/ajouter")) {
			splitArray1 = str.split(" ");
			for (int i = 0; i < splitArray.length; i++) {
				// On affiche chaque élément du tableau
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				System.out.println("element n° " + i);
				System.out.println("date: " + splitArray1[3] + "]");
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				this.total = i;
			}
			    System.out.println("-+-+-+-+-+-+-+-" + this.total);
	//	}
		        return splitArray[3];
	}
}

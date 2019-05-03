package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfece.ServreAppacheTrining;
import com.example.demo.model.DBFile;
@Service
public class AppacheServerServiceTrining implements ServreAppacheTrining{
	@Autowired
	private DBFileStorageService dBFileStorageService;
	
	private String serverName="";
	private Long occurenceOfKey=null;
 

	@Override
	public String appacheFiltrageToGetServer(String fieldId) {

		DBFile dbFile= this.dBFileStorageService.getFile(fieldId);
		String fileGetContent = new String(dbFile.getData());
		if (fileGetContent.contains("[error] [client ")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] [error] [client ")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] [error] [error] proxy: AJP: disabled connection for")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] [error] (111)Connection refused: ")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] [notice] caught SIGTERM")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] [notice] Apache configured --")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("/ QUERY=")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains(".NET CLR")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains(".NET4.0C; ")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains(".NET4.0E; ")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains(" 80 GET /")) {
			this.serverName="Appache_server";
		}
		
		if (fileGetContent.contains("] File does not exist: /")) {
			this.serverName="Appache_server";
		}
	
		return this.serverName;
	}

	@Override
	public String appacheFiltrageToGetEstimation(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date appacheFiltrageToGetDate(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long appacheFiltrageToGetOccurence(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

}

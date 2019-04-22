package com.example.demo.service;

import java.io.IOException;

import javax.websocket.server.ServerApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.FileController;
import com.example.demo.interfece.ServreAppacheTrining;
import com.example.demo.interfece.ServreJbossTrining;
import com.example.demo.interfece.ServreTomcatTrining;
import com.example.demo.model.DBFile;

@Service
public class ServerTriningService implements ServreAppacheTrining, ServreJbossTrining, ServreTomcatTrining{

	@Autowired
	private DBFileStorageService dBFileStorageService;
	@Autowired
	private FileController fileController;
    private	String reponseOfSearch="";
	
	@Override
	public String tomcatFiltrage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String tomcatFiltrageEstimation(String  fileId) {
		// TODO Auto-generated method stub
		try {
			this.fileController.downloadFile(fileId);
			DBFile dbFile = this.dBFileStorageService.getFile(fileId);
			String filtreChaine = new String(dbFile.getData());
			
			if (filtreChaine.contains("")) {
				 reponseOfSearch= "Tomcat_Server";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reponseOfSearch;
	}

	@Override	
	public String jbossFiltrage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jbossFiltrageEstimation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String appacheFiltrage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String appacheFiltrageEstimation() {
		// TODO Auto-generated method stub
		return null;
	}
	


}

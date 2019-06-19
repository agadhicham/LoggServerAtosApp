package com.example.demo.service;

import java.io.IOException;
import java.util.Date;

import javax.websocket.server.ServerApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.controller.FileController;
import com.example.demo.interfece.ServreAppacheTrining;
import com.example.demo.interfece.ServreJbossTrining;
import com.example.demo.interfece.ServreTomcatTrining;
import com.example.demo.model.DBFile;

@Service
public class ServerTriningService implements ServreAppacheTrining, ServreJbossTrining, ServreTomcatTrining {

	@Autowired
	private DBFileStorageService dBFileStorageService;

	@Autowired
	private FileController fileController;

	private String reponseOfSearch = "";

	@Override
	public String tomcatFiltrageToGetEstimation(@PathVariable String fileId) throws IOException {
			DBFile dbFile = this.dBFileStorageService.getFile(fileId);
			String filtreChaine = new String(dbFile.getData());
			

			if (filtreChaine.contains("[error]")) {
				reponseOfSearch = "Tomcat_Server";
			}

		return reponseOfSearch;
	}

	@Override
	public String tomcatFiltrageToGetServer(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jbossFiltrageToGetServer(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String jbossFiltrageToGetEstimation(String fieldId) {
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

	@Override
	public String[] tomcatFiltrageToGetDate(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tomcatFiltrageToGetOccurence(String fieldId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date jbossFiltrageToGetDate(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long jbossFiltrageToGetOccurence(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String appacheFiltrageToGetServer(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String appacheFiltrageToGetEstimation(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String tomcatFiltrageToGetDateFormat(String fieldId) {
		// TODO Auto-generated method stub
		return null;
	}

}

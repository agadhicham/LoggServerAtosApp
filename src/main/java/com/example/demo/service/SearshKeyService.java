package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DBFile;
import com.example.demo.model.DBfileExtractionDataToSave;

@Service
@RestController
@RequestMapping(path="/result")
public class SearshKeyService {
	
	@Autowired
	private JbossServerServiceTrining jbossServerServiceTrining;
	@Autowired
	private TomcatServerServiceTrining tomcatServerServiceTrining;
	@Autowired
	private AppacheServerServiceTrining appacheServerServiceTrining;
	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	private List<String> dbfileExtractionDataToSaves= new ArrayList<>();
	private String Server_Name="";
	private Long occurence=null;
	private String [] getDate=null;


	@GetMapping("/date/{fileId}")
	public String [] getSearshByKeyToGetDate(String searshKey,String fileId) {
		 DBFile dbFile = this.dbFileStorageService.getFile(fileId);
		 String contentSearsh= new String(dbFile.getData());
		 if (contentSearsh.contains(searshKey)) {
			 tomcatServerServiceTrining.tomcatFiltrageToGetDate(fileId);
			 appacheServerServiceTrining.appacheFiltrageToGetDate(fileId);
			 jbossServerServiceTrining.jbossFiltrageToGetDate(fileId);
		}
		return getDate ;
	}
	@GetMapping("/occurence")
	public Long getSearshByKeyToGetOccurence(String searshKey,String fileId) {
		 DBFile dbFile = this.dbFileStorageService.getFile(fileId);
		 String contentSearsh= new String(dbFile.getData());
		 if (contentSearsh.contains(searshKey)) {
			 try {
				tomcatServerServiceTrining.tomcatFiltrageToGetOccurence(fileId, contentSearsh);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 appacheServerServiceTrining.appacheFiltrageToGetOccurence(fileId);
			 jbossServerServiceTrining.jbossFiltrageToGetOccurence(fileId);  
		}
		return occurence ;
	}
	
	@GetMapping("/server")
	public String getSearshByKeyToGetServer(String searshKey,String fileId) {
		 DBFile dbFile = this.dbFileStorageService.getFile(fileId);
		 String contentSearsh= new String(dbFile.getData());
		 if (contentSearsh.contains(searshKey)) {
			 tomcatServerServiceTrining.tomcatFiltrageToGetServer(fileId);
			 appacheServerServiceTrining.appacheFiltrageToGetServer(fileId);
			 jbossServerServiceTrining.jbossFiltrageToGetServer(fileId);
		}
		return Server_Name ;
	}

}

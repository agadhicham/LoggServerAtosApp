package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DBFile;
import com.example.demo.service.DBFileStorageService;


@RestController
@RequestMapping(path="/results")
public class TriningResult {

	@Autowired
	private DBFileStorageService dBFileStorageService; 

	@GetMapping("/final/{fileId}")
	public String getResultOfSearsh(@PathVariable String fileId) {
		System.out.println("ananan");
		DBFile dbFile=dBFileStorageService.getFile(fileId);
		String contentChar=new String(dbFile.getData());
		System.out.println(contentChar);
		String [] words = contentChar.split(" ");
		int wrc=1;
		for (int i = 0; i < words.length; i++) {
			
			for (int j = i+1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					wrc=wrc+1;
					words[j]="0";
				}
			}
			if (words[i]!="0") {
				System.out.println(words[i] +"---"+wrc);
				wrc=1;
			}
		}
		
		return "---"+wrc;
	}
	
	
}

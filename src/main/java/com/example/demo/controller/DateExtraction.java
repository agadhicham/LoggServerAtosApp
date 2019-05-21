package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DBFile;
import com.example.demo.service.DBFileStorageService;

@RestController
public class DateExtraction {

	
	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	
	@GetMapping("/dateExtraction/{id}")
	public String dateExtraction(@PathVariable String idFile) {
		DBFile dbFile= this.dbFileStorageService.getFile(idFile);
		String contentFile = new String (dbFile.getData());
		System.out.println(contentFile);
		return contentFile;
	}
	
}

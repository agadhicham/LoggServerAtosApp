package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AppacheServerServiceTrining;

@RestController
@RequestMapping(path="/appache/server")
public class AppacheApiFilter {
	@Autowired
	private AppacheServerServiceTrining appacheServerServiceTrining;
	
	@GetMapping("/serverName")
	public String appacheServerGetGeneratedName(String fileId) {
		return this.appacheServerServiceTrining.appacheFiltrageToGetServer(fileId);
	}
	
	
	@GetMapping("/cleDateGenerated")
	public Date appacheServerGetGeneratedCleDate(String fileId) {
		return this.appacheServerServiceTrining.appacheFiltrageToGetDate(fileId);
		
	}
	 
	@GetMapping("/occurrenceTotal")
	public Long appacheServerGetCleGeneratedSumOfOcurrence(String fileId) {
		return this.appacheServerServiceTrining.appacheFiltrageToGetOccurence(fileId);
		
	}
	
	
	

}

package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AutowiredUses;
import com.example.demo.service.TomcatServerServiceTrining;

@RestController
@RequestMapping(path="/tomcat/server")
public class TomcatApiFilter {


	
	@Autowired
	private TomcatServerServiceTrining tomcatServerServiceTrining;
	
	@GetMapping("/serverName/{fileId}")
	public String getTomcatServerName(@PathVariable String fileId) {
		
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetServer(fileId);
	}
	
	@GetMapping("/serverDate/{fileId}")
	public String[] getTomcatServerDate(@PathVariable String fileId) {
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetDate(fileId);
	}
	
	@GetMapping("/serverCleOccurence")
	public Long getTomcatServerCleOccurence(@PathVariable String fileId) {
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetOccurence(fileId);
	}
}

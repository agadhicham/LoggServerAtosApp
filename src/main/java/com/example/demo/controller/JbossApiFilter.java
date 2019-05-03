package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.JbossServerServiceTrining;

@RestController
@RequestMapping(path="/jboss/server")
public class JbossApiFilter {
	
	
	@Autowired
	private JbossServerServiceTrining jbossServerServiceTrining;
	
	
	@GetMapping("/getName")
	public String jbossServerGetName(String fileId) {
		return this.jbossServerServiceTrining.jbossFiltrageToGetServer(fileId);
	}
	
	@GetMapping("/getCleGenerateDate")
	public Date jbossServerGetDate(String fileId) {
		
		return this.jbossServerServiceTrining.jbossFiltrageToGetDate(fileId);
	}
	
	@GetMapping("/getCleOccurence")
	public Long jbossServerGetOccurence(String fileId) {
		return this.jbossServerServiceTrining.jbossFiltrageToGetOccurence(fileId);
	}

}

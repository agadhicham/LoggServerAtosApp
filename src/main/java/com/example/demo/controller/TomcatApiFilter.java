package com.example.demo.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AutowiredUses;
import com.example.demo.service.TomcatServerServiceTrining;

//@Controller
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/tomcat/server")
public class TomcatApiFilter {

	@Autowired
	private TomcatServerServiceTrining tomcatServerServiceTrining;

	@GetMapping("/serverName/{fileId}")
	public String getTomcatServerName(@PathVariable String fileId) {

		return this.tomcatServerServiceTrining.tomcatFiltrageToGetServer(fileId);
	}

	@GetMapping("/serverDate/{fileId}")
	public String[] getTomcatServerDate(@PathVariable String fileId
	// @RequestParam(name="searshKey", defaultValue="") String searshKey
	) {
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetDate(fileId);
	}

	@GetMapping("/serverDateFormat/{fileId}")
	public String getTomcatServerDateFormat(@PathVariable String fileId
	// @RequestParam(name="searshKey", defaultValue="") String searshKey
	) {
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetDateFormat(fileId);
	}

	@GetMapping("/serverCleOccurence/{fileId}")
	public int getTomcatServerCleOccurence(@PathVariable String fileId) throws IOException {
		return this.tomcatServerServiceTrining.tomcatFiltrageToGetOccurence(fileId);
	}

}

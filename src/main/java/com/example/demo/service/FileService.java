package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.metier.FileImplementation;

@RestController
@RequestMapping("/files")
public class FileService {
	
	@Autowired
	private FileImplementation  fileImplementation;
	
	
	
	@GetMapping(value="/getAllFiles")
	public List<File> getAllFiles(){
		return  fileImplementation.findAllFiles();
	}
	
	@GetMapping(value="/{id}")
	public File getOneFile(@PathVariable Long id) {
		return fileImplementation.getOneFileUploaded(id);
	}
	
	@PostMapping(value="/newFile")
	public File saveFile(@RequestBody File  file) {
		
		ServerCategorie serverCategorie2= new ServerCategorie();
        return fileImplementation.saveFile(new File(null, null, null, null, serverCategorie2));	
	}
	
	@DeleteMapping(value="/{id}")
	public boolean feleteFile(@PathVariable Long id) {
		return fileImplementation.deleteFileUploaded(id);
		
	}

}

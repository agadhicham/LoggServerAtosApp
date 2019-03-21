package com.example.demo.interfece;

import java.util.List;

import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;

public interface FileInt {

	
	public List<File> findAllFiles();
	public File saveFile(File file);
	public File getOneFileUploaded(Long id);
	public boolean deleteFileUploaded(Long id);
	
}

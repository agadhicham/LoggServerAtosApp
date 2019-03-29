package com.example.demo.metier;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.FileRepository;
import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.interfece.FileInt;

@Service
public class FileImplementation implements FileInt {

	@Autowired
	private FileRepository fileRepository; 
	@Override
	public List<File> findAllFiles() {
		return fileRepository.findAll();
	}

	@Override
	public File saveFile(File file) {
		ServerCategorie  serverCategorie= new  ServerCategorie(null, null, null);
		File file2= new File(null, null, null, null, serverCategorie);
		return fileRepository.saveAndFlush(file);
	}

	@Override
	public File getOneFileUploaded(Long id) {
		return fileRepository.findById(id).get();
	}

	@Override
	public boolean deleteFileUploaded(Long id) {
		fileRepository.deleteById(id);
		return true;
	}



}

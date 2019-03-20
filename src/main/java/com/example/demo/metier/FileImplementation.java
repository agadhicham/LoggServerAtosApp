package com.example.demo.metier;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.FileRepository;
import com.example.demo.dao.StorageService;
import com.example.demo.entities.File;

@Service
public class FileImplementation implements StorageService {

	@Autowired
	private FileRepository fileRepository; 
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(MultipartFile file,File file2) {
		
		fileRepository.save(file2);
		
	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}

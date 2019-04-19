//package com.example.demo.controller;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.stream.Stream;
//
//import javax.validation.constraints.Pattern;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dao.DBFileRepository;
//import com.example.demo.model.DBFile;
//import com.example.demo.service.DBFileStorageService;
//
//@RestController()
//@RequestMapping("/files")
//public class FileAutomatisationFilterServer {
//	
//	@Autowired
//	private FileController fileController;
//	@Autowired
//	private DBFileStorageService dbFileStorageService;
//	
//	@Autowired
//	private DBFileRepository dBFileRepository;
//	
//	@RequestMapping(value="/filterInFile/{motCle}")
//    public String getServerFilter(@PathVariable String motCle) {
//		sy
//		fileController.downloadFile(motCle);
//		return motCle;
//	}
//	@GetMapping(value = "/getAllFiles")
//	public List<DBFile> getAll() {
//		return dBFileRepository.findAll();
//	}
//
//}

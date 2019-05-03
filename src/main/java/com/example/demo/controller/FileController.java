package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.DBFileRepository;
import com.example.demo.entities.File;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.model.DBFile;
import com.example.demo.payload.UploadFileResponse;
import com.example.demo.service.ServerTriningService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;

/* 
 * Création d'un API REST pour le telechargement de fichier ou des pulusieurs fichiers 
 * ainsi que la récuperation du fichier télecharger
 * */
//@RequestMapping("/files")
@Service
@RestController
@CrossOrigin(origins = "http://localhost:4444", allowedHeaders = "*")

public class FileController {
    private ResponseEntity<ByteArrayResource> resultat;
	@Autowired
	private com.example.demo.service.DBFileStorageService DBFileStorageService;

	@Autowired
	private DBFileRepository dBFileRepository;
	 @Autowired
	 private ServerTriningService serverTriningService;
	

    
	@PostMapping(value = "/uploadFile"// ,consumes = { "multipart/form-data", MediaType.APPLICATION_JSON_VALUE }
			)
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		DBFile dbFile = DBFileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                                            .path("/downloadFile/")
				                                            .path(dbFile.getId()).toUriString();
		return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files)
				.stream()
				.map(file -> uploadFile(file))
				//collect permet ici simplement de stocker le résultat dans une liste
				.collect(Collectors.toList());
	}

	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws IOException {	
		// chargement d'un fichier à partie de la base de donnée
		DBFile dbFile = DBFileStorageService.getFile(fileId);
		
		String IdFilePath=dbFile.getId();
		System.out.println("Id fichier pour le path "+IdFilePath);
		StringBuilder contentBuilder = new StringBuilder();
		String path="http://localhost:8081/downloadFile/"+IdFilePath;
		/*try (Stream<String> stream = Files.lines(Paths.get(fileId), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
//		boolean retval =contentBuilder.toString().contains("[error]");
//		if (retval) {
//			System.out.println("s'agit de serveur appache "+retval);
//		}
//		else {
//			System.out.println("arrive pas à specifier !!!"+retval);
//		}
	
		String fichierFiltrer = new String(dbFile.getData());
		
		if (fichierFiltrer.contains("[error]")) {
			System.out.println("il s'agit de serveur appache");
		}
		else 
			System.out.println("oooppppsss");
		
	//	this.serverTriningService.tomcatFiltrageEstimation(fileId);
		
		System.out.println(fichierFiltrer);
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + dbFile.getFileName().toString()+ "\"")
				.body(new ByteArrayResource(dbFile.getData()));		
	}
	

	
	@GetMapping(value = "/getAllFiles")
	public List<DBFile> getAll() {
		return dBFileRepository.findAll();
	}

	@GetMapping("/filesOfCat/{id}")
	public List<DBFile> getFilesByCta(@PathVariable(value = "id") Long id) {
		System.out.println(dBFileRepository.findByServerCategorieId(id));
		return this.dBFileRepository.findByServerCategorieId(id);
	}

	@GetMapping("/filesOfCategorie/{id}")
	public List<DBFile> getFilesByCtat(@PathParam(value = "id") String id) {
		System.out.println("rrrrrrrrrr");

		System.out.println("aaaaaaaaaaaa"+dBFileRepository.findByServerCategorieId(id).stream());
		System.out.println("rrrrrrrrrr");
		
		
		String fichierFiltrer= ""; 
//System.out.println(dBFileRepository.findByServerCategorieId(id));
		return this.dBFileRepository.findByServerCategorieId(id);
	}

	
//    @GetMapping("/selectOneFile/{id}")
//    public  DBFile getOneFile(@PathVariable(value="id") String id)  {
//    	System.out.println("ttotootototot"+id);
//        return this.DBFileStorageService.getFile(id);
//    }

	// facultafif ca va etre utiliser !!!! 
	@RequestMapping(value="/readFileToString/{filePath}")
	private String readLineByLineJava8(@PathVariable(name="filePath") String filePath) {
		DBFile dbFile = DBFileStorageService.getFile(filePath);
		ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));

		StringBuilder contentBuilder = new StringBuilder();
		System.out.println(contentBuilder.toString());
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contentBuilder.toString());
		return contentBuilder.toString();
	}

	@RequestMapping(value = "/chercherUnFichier")
	public Page<DBFile> chercher(@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "6") int s,
			@RequestParam(name = "motCle", defaultValue = "") String motCle) {
		System.out.println(dBFileRepository.chercherFichier("%" + motCle + "%", new PageRequest(p, s)));
		return dBFileRepository.chercherFichier("%" + motCle + "%", new PageRequest(p, s));
	}
//    @RequestMapping(value="/chercherUnFichier")
//    public Page<DBFile> cherche
//            (@RequestParam(name = "page", defaultValue = "0") int p,
//        			@RequestParam(name = "size", defaultValue = "6") int s,
//        			@RequestParam(name = "motCle", defaultValue = "") String motCle) {
//    	System.out.println(dBFileRepository.chercherFichier("%" + motCle + "%", new PageRequest(p, s)));
//       return dBFileRepository.chercherFichier("%" + motCle + "%", new PageRequest(p, s));	
//    }
	
//	@GetMapping("/downloadFile/{fileId}")
//	public ResponseEntity<Resource> downloadFil(@PathVariable String fileId,@PathVariable String motRchercher) {
//		// chargement d'un fichier à partie de la base de donnée
//		DBFile dbFile = DBFileStorageService.getFile(fileId);
//	System.out.println(dbFile.getData());
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + dbFile.getFileName() + "\"")
//				.body(new ByteArrayResource(dbFile.getData()));
//	}
	
	
}

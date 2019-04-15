package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ServerCategorieRepository;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.metier.CategorieImplimentation;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("/categories")
@CrossOrigin(allowedHeaders="*",value="*")
public class CategorieService {

	private List<String> url= new ArrayList<>();
	@Autowired
	private CategorieImplimentation categorieImplimentation;
	
	@GetMapping(value="/allCategories")
	public List<ServerCategorie> getAllCat(){
		return categorieImplimentation.findAll();
	}
	
	@JsonIgnore
	@PostMapping(value="/addServerCategori")
	public ServerCategorie saveServerCategorie(@RequestBody ServerCategorie serverCategorie) {
		return categorieImplimentation.saveCategorie(serverCategorie);
	}
	
	@GetMapping(value="/getOneServerCategorie/{id}")
	public ServerCategorie getOneServerCategorie(@PathVariable Long id) {
		return categorieImplimentation.getOneCategorie(id);
	}
	
	@DeleteMapping(value="/{id}")
	public boolean deleteOneServerCategorie(@PathVariable Long id) {
	return categorieImplimentation.deleteCategorieById(id);
	}
	
//	@GetMapping(value="/categorierPicture/{url}")
//	public ServerCategorie getCategoriePicture(@PathVariable Long id) {
//		
//		return categorieImplimentation.getOneCategorie(id);
//	}
//	
}
	


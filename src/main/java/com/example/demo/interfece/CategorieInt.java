package com.example.demo.interfece;

import java.util.List;

import com.example.demo.dao.ServerCategorieRepository;
import com.example.demo.entities.ServerCategorie;

public interface CategorieInt {
	
	public List<ServerCategorie> findAll();
	public ServerCategorie saveCategorie(ServerCategorie serverCategorie);
	public ServerCategorie getOneCategorie(Long id);
	public boolean deleteCategorieById(Long id);
	


}

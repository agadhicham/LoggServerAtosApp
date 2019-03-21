package com.example.demo.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.ServerCategorieRepository;
import com.example.demo.entities.ServerCategorie;
import com.example.demo.interfece.CategorieInt;

@Service
public class CategorieImplimentation implements CategorieInt{

	@Autowired
	private ServerCategorieRepository serverCategorieRepository;

	@Override
	public List<ServerCategorie> findAll() {
		return serverCategorieRepository.findAll();
	}
	@Override
	public ServerCategorie saveCategorie(ServerCategorie serverCategorie) {
		return serverCategorieRepository.saveAndFlush(serverCategorie);
	}
	@Override
	public ServerCategorie getOneCategorie(Long id) {
		return serverCategorieRepository.findById(id).get();
	}
	@Override
	public boolean deleteCategorieById(Long id) {
		
		serverCategorieRepository.deleteById(id);
		return true;
	}



}

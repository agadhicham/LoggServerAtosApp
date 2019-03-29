package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.ServerCategorie;
import com.example.demo.model.DBFile;

public interface ServerCategorieRepository extends JpaRepository<ServerCategorie, Long>{


}

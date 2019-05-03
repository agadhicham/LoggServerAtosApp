package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ServerCategorie;
import com.example.demo.model.DBFile;

@Repository

public interface DBFileRepository extends JpaRepository<DBFile, String>{
	//public List<DBFile> findByServerCategorie(ServerCategorie serverCategorie);

	public List<DBFile> findByServerCategorieId(Long idCategorie);
	public List<DBFile> findByServerCategorieId(String idCategorie);

	public DBFile findById (Long id);

	@Query("select f from DBFile f where f.fileName like :x")
	Page<DBFile> chercherFichier (@Param("x")String motCle,Pageable pageable );
	

}

package com.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sid.entities.Categorie;
import com.sid.entities.Product;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, String> {
	
	//@CrossOrigin(methods = RequestMethod.POST)
	//@RestResource(path="ajouterCategorie")
	//public Categorie addCategories(@Param("c") Categorie c);
}

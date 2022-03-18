package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Categorie;
import com.sid.entities.LigneCart;

import java.util.List;

@CrossOrigin("*") 
@RepositoryRestResource
public interface LigneCartRepository extends JpaRepository<LigneCart, Long> {


}

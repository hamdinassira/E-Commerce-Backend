package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Facture;

@CrossOrigin("*") 
@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long> {

}

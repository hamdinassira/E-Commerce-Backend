package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Compte;

@CrossOrigin("*") 
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

}

package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.entities.Facture;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long> {

}

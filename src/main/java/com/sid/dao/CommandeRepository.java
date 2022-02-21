package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.entities.Commande;

@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}

package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.entities.Cart;
import com.sid.entities.Categorie;

@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Long> {

}

package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Cart;
import com.sid.entities.Categorie;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Long> {

}

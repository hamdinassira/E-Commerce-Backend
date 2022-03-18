package com.sid.dao;

import java.util.List;

import com.sid.entities.LigneCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Product;

@CrossOrigin("*") //Pour autoriser tout les domaine a acceder a cet Api rest
@RepositoryRestResource
//public interface ProductRepository extends MongoRepository<Product, String> {
public interface ProductRepository extends JpaRepository<Product, String> {
	
    @RestResource(path="selected")
	public List<Product> findBySelectedIsTrue();

	@RestResource(path="notselected")
	public List<Product> findBySelectedIsFalse();
	
	//Avec la methode spring data rest on peut chercher un produit comme mentionner dans la methode suivante:
	@RestResource(path="findByCritere")
	public List<Product> findByNameContains(@Param("mot") String mot);
	
	//On peut utiliser une requete HQL aussi comme suit:
	//@Query("Select p from Product p where p.name like : x")
	//public List<Product> chercher(@Param("x") String mot);
	
	  /*@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
	            + " OR p.description LIKE %?1%"
	            + " OR p.price LIKE %?1%"
	            + " OR CONCAT(p.price, '') LIKE %?1%")
	    public List<Product> search(String keyword);*/
	
	@RestResource(path="stock")
	public List<Product> findByStockIsTrue();

	

	@RestResource(path="promo")
	public List<Product> findByPromotionIsTrueAndStockIsTrue();
	
	

	
	
}

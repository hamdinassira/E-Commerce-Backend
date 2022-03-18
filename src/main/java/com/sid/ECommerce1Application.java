package com.sid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.entities.Categorie;
import com.sid.entities.Commande;
import com.sid.entities.Product;
import com.sid.service.ICommercerService;


@SpringBootApplication
@CrossOrigin("*")
public class ECommerce1Application implements CommandLineRunner{

	@Autowired
	private ICommercerService iCommerceService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;//utiliser pour dire a spring data rest d'exposer l'id
	
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerce1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		// TODO Auto-generated method stub
		
		repositoryRestConfiguration.exposeIdsFor(Product.class, Categorie.class, Commande.class);
 
		iCommerceService.initCart();
		iCommerceService.initCategorie();
		iCommerceService.initCommande();
		iCommerceService.initCompte();
		iCommerceService.initFacture();
		iCommerceService.initProduct();
		iCommerceService.initLigneCart();
		
		
	}
}

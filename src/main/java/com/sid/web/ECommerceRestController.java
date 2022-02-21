package com.sid.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.CategorieRepository;
import com.sid.dao.ProductRepository;
import com.sid.entities.Product;

@RestController
public class ECommerceRestController {
	
	@Autowired //Utiliser pour l'injection des dependances
	ProductRepository productRepository;
	
	//On peut injecter les dependances soit avec l'annotation @Autowired ou bien avec un constructeur comme ci dessous:
	CategorieRepository categoryRepository;
	
	public ECommerceRestController(CategorieRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}

	@GetMapping(path = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name="id") Long id) throws Exception{
		Product product=productRepository.findById(id).get();
		String photoName=product.getImage();
		File file=new File(System.getProperty("user.home")+"/e Commerce/images/"+photoName+".jpg");
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
		
	}
	
	@GetMapping(path="/listProducts")
	public List<Product> products(){
		return productRepository.findAll();
	}

}

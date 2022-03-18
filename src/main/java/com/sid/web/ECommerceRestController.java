package com.sid.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sid.dao.CategorieRepository;
import com.sid.dao.ProductRepository;
import com.sid.entities.Product;
import com.sid.service.CommercerServiceImp;

@CrossOrigin("*")
@RestController
public class ECommerceRestController {
	
	@Autowired //Utiliser pour l'injection des dependances
	ProductRepository productRepository;
	
	 @Autowired
	    private CommercerServiceImp commerceserviceImp;
	
	//On peut injecter les dependances soit avec l'annotation @Autowired ou bien avec un constructeur comme ci dessous:
	CategorieRepository categoryRepository;
	
	public ECommerceRestController(CategorieRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}
	
	
	     
	    @RequestMapping("/")
	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
	        List<Product> listProducts = commerceserviceImp.listAll(keyword);
	        model.addAttribute("listProducts", listProducts);
	        model.addAttribute("keyword", keyword);
	         
	        return "index";
	    }

	@GetMapping(path = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name="id") String id) throws Exception{
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
	
	@PostMapping(path="/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file, @PathVariable String id) throws Exception {
		Product p=productRepository.findById(id).get();
		p.setImage(file.getOriginalFilename());
		String photoName=p.getImage();
		Files.write(Paths.get(System.getProperty("user.home")+"/e Commerce/images/"+photoName+".jpg"), file.getBytes());
		productRepository.save(p);
	}

}

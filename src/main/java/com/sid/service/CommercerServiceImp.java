package com.sid.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.CartRepository;
import com.sid.dao.CategorieRepository;
import com.sid.dao.CommandeRepository;
import com.sid.dao.CompteRepository;
import com.sid.dao.FactureRepository;
import com.sid.dao.LigneCartRepository;
import com.sid.dao.ProductRepository;
import com.sid.entities.Cart;
import com.sid.entities.Categorie;
import com.sid.entities.Commande;
import com.sid.entities.LigneCart;
import com.sid.entities.Product;
import com.sid.entities.Compte;
import com.sid.entities.Facture;

@Transactional
@Service
public class CommercerServiceImp implements ICommercerService{

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private LigneCartRepository ligneCartRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void initCart() {
		// TODO Auto-generated method stub
		List<LigneCart> ligneCart=ligneCartRepository.findAll();
			Cart cart=new Cart();
			
		ligneCart.forEach(l->{
			double total =	0.0;
		total=total+l.getPrixTotal();
		cart.setLigneCarts( (Collection<LigneCart>) ligneCart.get(new Random().nextInt(ligneCart.size())));
		cart.setLigneCarts(ligneCart);
		cart.setPrixTotal(total);
		cartRepository.save(cart);
		});
	}

	@Override
	public void initCategorie() {
		// TODO Auto-generated method stub
		Stream.of("informatique", "electronique", "sport", "Téléphone et tablette")
		.forEach(categorieName ->{
			Categorie categorie=new Categorie();
			
			categorie.setNom(categorieName);
			categorieRepository.save(categorie);
			
		});
	}

	@Override
	public void initCommande() {
		// TODO Auto-generated method stub
		Date date=new Date();
		factureRepository.findAll().forEach(f->{
			Commande commande=new Commande();
			commande.setDate(date);
			commande.setNbrArticle(1+(int)(Math.random()*10));
			commande.setFacture(f);
			commandeRepository.save(commande);
			
		});
	}

	@Override
	public void initCompte() {
		// TODO Auto-generated method stub
		Stream.of("admin", "nassira", "hamdi").forEach(nom->{
			Stream.of("Abc123@", "123Abc#", "@Abc1234")
			.forEach(password->{
				Compte compte=new Compte();
				/*compte.setNomComplet(nom);
				compte.setEmail(nom);
				compte.setPassword(password);*/
				compteRepository.save(compte);
			});
		});
	}

	@Override
	public void initFacture() {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		Facture facture=new Facture();
		facture.setDate(date);
		facture.setNumFact(1+(int)(Math.random()*1000));
		factureRepository.save(facture);
	}

	@Override
	@Transactional
	public void initProduct() {
		// TODO Auto-generated method stub
		double[] prix=new double[] {1089.00 , 1129.00, 39.90, 479.00};
		categorieRepository.findAll().forEach(c ->{
			Stream.of("Ordinateurs", "Télévision", "Sport et Fitnesse", "Smartphones")
			.forEach(productName->{
				Stream.of("Hp Pc HP15 - N4020 4M - 8G - 1T - Win10 - Argent - Garantie 1an",
						"Samsung Téléviseur 40\" Full HD TV N5000 Serie 5 - Garantie 1 an",
						"Iron Gym Barre fixe démontable",
						"ZTE Blade V30 Vita - 6.82\" - 4 Go - 64 Go - Bleu - Garantie 1 an")
				.forEach(descriptionProoduct->{
				//ligneCartRepository.findAll().forEach(ligneCart->{
					Product product=new Product();
					Random rnd=new Random();
					 product.setName(productName);
					    product.setDescription(descriptionProoduct);
					    product.setPrice(prix[(int) new Random().nextDouble()]);
					    product.setImage(productName.toLowerCase());
					    product.setStock(rnd.nextBoolean());
					    product.setPromotion(rnd.nextBoolean());
					    product.setSelected(rnd.nextBoolean());
					    product.setCategorie(c);
			    //product.setLigneCart(ligneCart);
			    productRepository.save(product);
				//});		
				
				});
			});
			
			
		});
		
	}

	@Override
	public void initLigneCart() {
		// TODO Auto-generated method stub
		List<Product> p=productRepository.findAll();
		cartRepository.findAll().forEach(cart->{
			LigneCart ligneCart=new LigneCart();
			ligneCart.setNbrArticle(1+(int)Math.random()*20);
			ligneCart.setCart(cart);
			ligneCart.setProducts((Collection<Product>) p.get(new Random().nextInt(p.size())));
			ligneCartRepository.save(ligneCart);
			
		});
			
		
	}
	

}

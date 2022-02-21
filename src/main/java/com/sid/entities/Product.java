package com.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String name;
	private String description;
	private double price;
	@Column(unique = true)
	private String reference;
	private boolean stock;
	private boolean promotion;
	private boolean selected;//les produits selctionnées par un client
	/*@Lob
    @Column(nullable = true, length = Integer.MAX_VALUE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private byte[] image;*/
	private String image;
	private int quantite;
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private LigneCart ligneCart;
	

}

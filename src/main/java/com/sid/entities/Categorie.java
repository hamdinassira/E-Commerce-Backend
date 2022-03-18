package com.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


//@Document
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Categorie implements Serializable{
	
	@Id
	private String idCategorie;
	@Column(length = 100)
	private String nom;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	
	@OneToMany(mappedBy = "categorie")//Association bidirectionnel
	//@DBRef
	private Collection<Product> products;

}

package com.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Facture implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private Date  date;
	@Column(unique = true)
	private int numFact;
	@OneToMany(mappedBy = "facture")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Commande> commandes;
}

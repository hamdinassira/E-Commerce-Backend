package com.sid.entities;

import java.io.Serializable;
import java.util.Collection;

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
public class Cart implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCart;
	private double prixTotal;
	@OneToMany(mappedBy = "cart")
	//@JsonProperty(access = Access.WRITE_ONLY)
    private Collection<LigneCart> ligneCarts;
    

}

package com.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;
	private String nomComplet;
	private String email;
	private String password;
	
}

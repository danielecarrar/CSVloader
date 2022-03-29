package it.epicode.be.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titolo;
	private String autore;
	
	
	public Book(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	

}

package jdk.ricettario.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ricetta {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String autore;
	@Column(nullable=false, unique = true)
	private String nomeRicetta;
	@Column(nullable=false)
	private String durata;
	@Column(nullable=false)
	private String descrizione;
	
	public Ricetta() {}
	
	

	public Ricetta(String autore, String nomeRicetta, String durata, String descrizione) {
		
		this.autore=autore;
		this.nomeRicetta = nomeRicetta;
		this.durata = durata;
		this.descrizione = descrizione;
		
	}
	
	
	public String getAutore() {
		return this.autore;
	}



	public void setAutore(String autore) {
		this.autore = autore;
	}



	public String getNomeRicetta() {
		return nomeRicetta;
	}

	public void setNomeRicetta(String nomeRicetta) {
		this.nomeRicetta = nomeRicetta;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " La ricetta nomeRicetta " + this.nomeRicetta + "di "+ this.autore+ ", presenta una durata di " + this.durata + ", ecco come procedere"
				+ this.descrizione;
	}
	
	
	
	

}

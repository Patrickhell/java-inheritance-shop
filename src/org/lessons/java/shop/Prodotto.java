package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
	
	
	
	
	private int codice;
	private String nome;
	private String descrizione ;
	private float prezzo;
	private int iva;
	
public Prodotto(int codice, String nome, String descrizione, float prezzo, int iva) {
		
	    generateNewRandomCode();
	
		setCodice(codice);
		setName(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setIva(iva);
	}

private void generateNewRandomCode() {
	
	Random rnd = new Random();
	
	
	setCodice(rnd.nextInt(0, 100)); //Integer.MAX_VALUE));
}

public int getCodice() {
	
	return codice;
}


private void setCodice(int codice) {
	
	this.codice = codice;
	
}

public String getName () {
	
	 return nome;
}
public void setName(String nome) {
	
	this.nome = nome;
}

public String getDescrizione() {
	
	return descrizione;
}

public void setDescrizione(String descrizione) {
	
	this.descrizione = descrizione;
}

public float getPrezzo() {
	
	return prezzo;
}

public void setPrezzo(float prezzo) {
	
	this.prezzo = prezzo;
}


public int getIva() {
	
	return iva;
}

public void setIva(int iva) {
	
	this.iva = 22;
}

public  float prezzoConIva() {
	
	return getPrezzo() / 100 * (100 + getIva());
					 
}
 public String nomeCodice(){
	 
	 return getName() + "-" + padLeftCodice();
 }
 
 public String padLeftCodice() {
     String codiceString = String.valueOf(getCodice()); // Converte il codice in stringa
     
     if (codiceString.length() < 8) {
         codiceString = String.format("%08d", getCodice()); // Aggiunge zeri se la lunghezza è inferiore a 8
     }
     
     return codiceString;
 }

 public double scontoCartaFedeltà(boolean hasFideltyCard) {
	 
	 double scontoBase = 0.02;
	 
	 if(hasFideltyCard) {
		 
		return prezzoConIva() - (prezzoConIva() * scontoBase);
		
     } else {
    	 
    	 return prezzoConIva();
     }
 }
 
 
 @Override
	public String toString() {
	 
	 return "codice: " + padLeftCodice() + "\n"
			 + "nome: " + getName() + "\n"
			 + "descrizione: " + getDescrizione() +  "\n"
			 + "prezzo: " + String.format("%.02f", getPrezzo()) + " " +  "euro " + "\n"
			 + "iva: " + getIva() + "%" + "\n"
			 + "pezzo incluso iva: " + String.format("%.02f", prezzoConIva()) + " " + "euro" +"\n"
			 + "nome-Codice: " + nomeCodice();
     }


		

}
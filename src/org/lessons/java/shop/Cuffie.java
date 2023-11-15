package org.lessons.java.shop;

public class Cuffie extends Prodotto  {

    private String colore;
    private boolean cablate;
    
    public Cuffie(int codice, String name, String descrizione, float prezzo, int iva,String colore, boolean cablate) {
    	
    	super(codice, name, descrizione, prezzo, iva);
    	
    	setColore(colore);
    	setCablate(cablate);
    	
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public boolean isCablate() {
		return cablate;
	}

	public void setCablate(boolean cablate) {
		this.cablate = cablate;
	}
	
	public double scontoPerCuffie(boolean isCablate) {
		 
		 double scontoCuffie = 0.07;
		 
		 if(isCablate) {
			 
			 return super.prezzoConIva() -(super.prezzoConIva() * scontoCuffie);
			 
		 } else {
			 
			 return super.scontoCartaFedeltà(true);
		 }
    }
    
    public String toString() {
		
		return "Caratteristiche: " + "\n"
		        + "Colore: " + getColore() + "\n"
				+ "Cablate: " + isCablate() + "\n"
				+ super.toString();
	}
	
}

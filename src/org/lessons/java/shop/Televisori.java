package org.lessons.java.shop;


public class Televisori extends Prodotto {
	
	private int dimensioni;
	private boolean isSmart;
	
	public Televisori (int codice, String name, String descrizione, float prezzo, int iva, int dimensioni, boolean isSmart) {
		
		super(codice, name, descrizione, prezzo, iva);
		
		setDimensioni(dimensioni);
		
		setSmart(isSmart);
	}
   
	
	
	
    public int getDimensioni() {
		return dimensioni;
	}




	public void setDimensioni(int dimensioni) {
		this.dimensioni = dimensioni;
	}




	public boolean isSmart() {
		return isSmart;
	}




	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
	}

	public double scontoPerTelevisore(boolean isSmart) {
		 
		 double scontoTelevisore = 0.1;
		 
		 if(isSmart) {
			 return super.prezzoConIva() -(super.prezzoConIva() * scontoTelevisore );
			 
		 } else {
			 
			 return super.scontoCartaFedeltà(true);
		 }
     }



	public String toString() {
		
		return "Caratteristiche: " + "\n"
		        + "Dimensioni:" + getDimensioni() + "pollici " + "\n"
				+ "Smart: " + isSmart() + "\n"
				+ super.toString();
	}
	

}

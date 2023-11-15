package org.lessons.java.shop;

public class Smartphone extends Prodotto {
	
	private int codiceIMEI;
	private int memoria;
	
	public Smartphone ( int codice, String name, String descrizione, float prezzo, int iva,int codiceIMEI, int memoria) {
		
		super(codice, name, descrizione, prezzo, iva);
		
		setCodiceIMEI(codiceIMEI);
		setMemoria(memoria);
		
	}

	public int getCodiceIMEI() {
		return codiceIMEI;
	}

	public void setCodiceIMEI(int codiceIMEI) {
		this.codiceIMEI = codiceIMEI;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	public void caratteristiche() {
		
		System.out.println("Caratteristiche del SmartPhone: ");
	}
	
	public double scontoPerSmartphone() {
		 
		 double scontoSmartphone = 0.05;
		 
		 if(getMemoria() < 32) {
			 
			 return super.prezzoConIva() - (super.prezzoConIva() * scontoSmartphone);
			 
		 } else {
			 
			 return super.scontoCartaFedeltà(true);
		 }
	 }
	 
	@Override
	
	
	public String toString() {
		
		caratteristiche();
		
		return "Caratteristiche: " + "\n"
				+"CODICE IMEI: " + getCodiceIMEI() + "\n"
				+ "MEMORIA:" + getMemoria() + "GB" + "\n"
				+ super.toString();
	}
	
	

}

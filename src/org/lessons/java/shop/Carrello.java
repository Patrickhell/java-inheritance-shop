package org.lessons.java.shop;

import java.util.Random;
import java.util.Scanner;

public class Carrello {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		Smartphone sp = new Smartphone(rnd.nextInt(0, 100), "Smartphone", "descrizione", rnd.nextInt(25, 50), 10, rnd.nextInt(0, 100), rnd.nextInt(6, 250));
		Televisori tv = new Televisori(rnd.nextInt(0, 100), "Televisore", "descrizione", rnd.nextInt(25, 50), 10, rnd.nextInt(6, 250), true);
		Cuffie cuf = new Cuffie(rnd.nextInt(0, 100), "Cuffie", "descrizione", rnd.nextInt(25, 50), 10, "colore", true);

	    
	    double scontoSmartphone = 0;
	    double scontoTelevisore = 0;
	    double scontoCuffie  = 0;
	    double scontoSmarphoneNoCard = 0;
	    double scontoTelevisoreNoCard = 0;
	    double scontoCuffieNoCard = 0;
	    boolean hasFidelityCard = false;
	    double totalePrezzo  = 0;
	    int totalePrezzoCarrello = 0;
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Hai la carta fedeltà? (sì/no)");
        String risposta = sc.nextLine().toLowerCase();
        
        if (risposta.equals("sì")) {
            hasFidelityCard = true;
        } else if (risposta.equals("no")) {
            System.out.println(" il prezzo sarà standard.");
        }
        
        int smartphoneCount = 0;
	    int televisoreCount = 0;
	    int cuffieCount = 0;
	    int sumCarrello = 0;


        do {
            System.out.println("Vuoi inserire un altro prodotto? (sì/no)");
             risposta = sc.nextLine().toLowerCase();

            if (risposta.equals("sì")) {
                System.out.println("Che prodotto vuoi inserire? smartphone / televisore / cuffie");
                String prodotto = sc.nextLine();

                switch (prodotto.toLowerCase()) {
                
                    case "smartphone":
                        smartphoneCount++;
                        
                        if(hasFidelityCard) {
                           scontoSmartphone = sp.scontoPerSmartphone();
                           
                        } else {
                        	scontoSmarphoneNoCard = sp.prezzoConIva();
                        }
                        break;
                        
                    case "televisore":
                        televisoreCount++;
                        
                        if(hasFidelityCard) {
                        	
                           scontoTelevisore  = tv.scontoPerTelevisore(false);

                        } else {
                        	
                        	scontoTelevisoreNoCard = tv.prezzoConIva();
                        }
                        break;
                        
                    case "cuffie":               	
                        cuffieCount++;
                        if(hasFidelityCard) {
                        	
                            scontoCuffie = cuf.scontoPerCuffie(true);
                        	
                        } else {
                        	
                        	scontoCuffieNoCard = cuf.prezzoConIva();                        }
                        break;
                        
                    default:
                        System.out.println("prodotto non valido.");
                        break;
                }
                
            } else if (!risposta.equals("no")) {
                System.out.println("Risposta non valida. Riprova.");
            }
            
        } while (!risposta.equals("no"));

            
        sumCarrello = smartphoneCount + televisoreCount + cuffieCount;
	    
	    System.out.println("\n----------------------\n");
		System.out.println("Smartphone: " + smartphoneCount + "\n" 
                            + "Prezzo con Sconto con carta fedeltà: " +  String.format("%.02f", scontoSmartphone) + "euro" + "\n" 
                            + "prezzo no carta fedeltà: " + String.format("%.02f",scontoSmarphoneNoCard)+ "euro" + "\n" 
                            + sp
				           );
		
		System.out.println("\n----------------------\n");
		System.out.println("Televisori: " + televisoreCount + "\n"
				            + "Prezzo con carta fedeltà: " + String.format("%.02f",scontoTelevisore) + "euro" + "\n" 
				            + "Prezzo no carta fedeltà: " + String.format("%.02f",scontoTelevisoreNoCard )+ "euro" + "\n" 
				            + tv
				          );
		
		System.out.println("\n----------------------\n");
		System.out.println("Cuffie: " + cuffieCount + "\n" 
				           + "Prezzo con carta fedeltà: " + String.format("%.02f", scontoCuffie) + "euro" + "\n" 
				           + "Prezzo no carta fedeltà: " + String.format("%.02f", scontoCuffieNoCard) + "euro" + "\n" 
                           + cuf
	                      );
		
		System.out.println("\n----------------------\n");
		
		System.out.println("totale prodotti nel carrello: " + sumCarrello);
		
		System.out.println("\n----------------------\n");
		
		
		if (hasFidelityCard) {
			totalePrezzo  = scontoSmartphone + scontoTelevisore + scontoCuffie;
		} else {
			totalePrezzo  = scontoSmarphoneNoCard + scontoTelevisoreNoCard + scontoCuffieNoCard;
		}
		
		

        System.out.println("Il totale del carrello è: " + String.format("%.02f",totalePrezzo)  + "euro" );

				
	}

}

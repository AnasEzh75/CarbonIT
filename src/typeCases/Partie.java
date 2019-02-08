package typeCases;

import java.util.HashMap;

import carteAuxTresors.CarteAuxTresors;
import enums.Action;

public class Partie {
	private HashMap<String, Aventurier> aventuriers = new HashMap<>();
	private Carte carte;
	CarteAuxTresors carteAuxTresors;
	
	private int cpt = 0;
	
	
	public Partie(HashMap<String, Aventurier> aventuriers, Carte carte) {
		super();
		this.aventuriers  = aventuriers;
		this.carte = carte;
		aventuriers = new HashMap<>();
	}
	
	public Partie(CarteAuxTresors carteAuxTresors){
		aventuriers = new HashMap<>();
		this.carteAuxTresors = carteAuxTresors;
	}
	
	public Partie lancerPartie(String fichierCarte){
		Carte carteJeu = carteAuxTresors.chargerCarte(fichierCarte);
		
		HashMap<String, Aventurier> mapAventuriers = new HashMap<>();
		
		Partie partie = new Partie(mapAventuriers, carteJeu);
        Boolean fin = false;
        while (!fin){
            fin = true;
            for (String nom: mapAventuriers.keySet()){
            		Action action = mapAventuriers.get(nom).getListAction().get(cpt);
            		Aventurier a = mapAventuriers.get(nom);
	            	fin = fin && false;
            }
            cpt++;
        }
		
		return partie;
	}
	
	public void resultatPartie(Partie partie){
		carteAuxTresors.enregistrerResultats(partie);
	}
	
	public HashMap<String, Aventurier> getAventuriers() {
		return aventuriers;
	}


	public Carte getCarte() {
		return carte;
	}
	
}

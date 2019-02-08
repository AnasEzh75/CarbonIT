package main;

import java.util.Scanner;

import carteAuxTresors.CarteAuxTresors;
import carteAuxTresors.CarteAuxTresorsImpl;
import typeCases.Partie;

public class CAT {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Fichier contenant la carte: ");
		String fichierCarte = sc.nextLine();
		sc.close();
		
		CarteAuxTresors carteAuxTresors = new CarteAuxTresorsImpl();

		Partie partie = new Partie(carteAuxTresors);
		partie.lancerPartie(fichierCarte);
		partie.resultatPartie(partie);
	}

}

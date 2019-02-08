package carteAuxTresors;


import typeCases.Carte;
import typeCases.Partie;

public interface CarteAuxTresors {
	
	public Carte chargerCarte(String fichierCarte);
	public void enregistrerResultats(Partie carte);
}

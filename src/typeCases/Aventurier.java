package typeCases;

import java.util.List;

import enums.Action;
import enums.Orientation;

public class Aventurier {
	private final String nom;
	private Position position;
	private Orientation orientation;
	private List<Action> listAction;
	
	private int nbTresor=0;
	
	public Aventurier(String nom, Position position, Orientation orientation, List<Action> listAction) {
		super();
		this.nom=nom;
		this.position = position;
		this.orientation = orientation;
		this.listAction = listAction;
	}

	
	public void ramasse(int tresor){
		nbTresor += tresor;
	}
	
	public static Aventurier newInstance(Aventurier aventurier){
		Aventurier a = 	new Aventurier(aventurier.getNom(), aventurier.getPosition(),aventurier.getOrientation(), aventurier.getListAction());
		a.setNbTresor(aventurier.getNbTresor());
		return a;
	}
	
	public List<Action> getListAction() {
		return listAction;
	}

	public void setListAction(List<Action> listAction) {
		this.listAction = listAction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}


	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String getNom() {
		return nom;
	}

	public int getNbTresor() {
		return nbTresor;
	}

	public void setNbTresor(int nbTresor) {
		this.nbTresor = nbTresor;
	}
	
	
	
}

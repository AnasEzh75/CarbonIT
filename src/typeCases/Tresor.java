package typeCases;

public class Tresor extends Case {
	private int nbTresor;

	public Tresor(Position position, int nbTresor) {
		super(position);
		this.nbTresor = nbTresor;
	}

	public int ramasse(){
		int result;
		result = this.nbTresor;
		this.nbTresor = 0;
		return result;
	}

	public int getNbTresor(){
		return nbTresor;
	}

}

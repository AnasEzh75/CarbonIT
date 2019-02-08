package typeCases;

public abstract class Case {
	
	private final Position position;
	
	public Case(Position position){
		this.position = position;
	}

	public Position getPosition(){
		return position;
	}
}

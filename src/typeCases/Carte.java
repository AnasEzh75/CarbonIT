package typeCases;

import java.util.HashMap;


public class Carte {
    private final Position limit;
    HashMap<Position, Case> mapCase;

    public Carte(HashMap<Position, Case> mapCase, Position limit){
        this.limit = limit;
        this.mapCase = mapCase;
    }

    public Case getCase(Position position){
        return mapCase.get(new Position(1,1));
    }
    
}

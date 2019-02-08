package Utils;


import enums.Action;

public class Utils {

	private String CST = "";
	
	public static Action stringToAction(String stringAction){
		switch(stringAction){
		case "A":
			return Action.AVANCE;
		case "D":
			return Action.DROITE;
		case "G":
			return Action.GAUCHE;
		default:
			return Action.ATTENDRE;
		}
	}
}

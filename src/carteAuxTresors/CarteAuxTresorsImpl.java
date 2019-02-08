package carteAuxTresors;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Utils.Utils;
import enums.Action;
import enums.Orientation;
import typeCases.Aventurier;
import typeCases.Carte;
import typeCases.Case;
import typeCases.Montagne;
import typeCases.Partie;
import typeCases.Position;
import typeCases.Tresor;

public class CarteAuxTresorsImpl implements CarteAuxTresors{
	@Override
	public Carte chargerCarte(String fichierCarte) {
		
			Stream<String> stream = null;
			
			try{
    			stream = Files.lines(Paths.get(fichierCarte));
				Files.lines(Paths.get(ClassLoader.getSystemResource(fichierCarte).toURI()));
    		}catch (Exception e){
    		}
			
			List<String> carteLigne = stream
	                .filter(line -> line.startsWith("C"))
	                .collect(Collectors.toList());
			
			String line = carteLigne.get(0);
	        Position limit = getDimensionsCarte(line);

	    		try{
	    			stream = Files.lines(Paths.get(fichierCarte));
					Files.lines(Paths.get(ClassLoader.getSystemResource(fichierCarte).toURI()));
	    		}catch (Exception e){
	    		}
				
	    	
	        List<String> lines = stream
	                .collect(Collectors.toList());
	        stream.close();
	        
	        HashMap<Position, Case> mapCase = typeCases(lines);
	        
			return new Carte(mapCase, limit);
	}
	
	private  Position getDimensionsCarte(String line){
        String[] splitLine =line.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
 
        return new Position(x, y);
    }
	
	private  HashMap<Position, Case> typeCases(List<String> lines){
		HashMap<Position, Case> mapCase = new HashMap<Position, Case>();
		
		for (String line: lines){
            if(line.startsWith("T")){
                caseTresors(line, mapCase);
            }else if(line.startsWith("M")){
            	caseMontagne(line, mapCase);
            }else if(line.startsWith("A")){
            	typeAventurier(line);
            }
            
        }
 
        return mapCase;
    }
	
	private void caseTresors(String line, HashMap<Position, Case> mapCase){
		String[] splitLine =line.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
        int numTresor =Integer.parseInt(splitLine[3]);
        
        Position position = new Position(x, y);
        Tresor tresor = new Tresor(position, numTresor);
        
        mapCase.put(position, tresor);
	}
	
	private void caseMontagne(String line, HashMap<Position, Case> mapCase){
		String[] splitLine =line.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
        
        Position position = new Position(x, y);
        Montagne montagne = new Montagne(position);
        
        mapCase.put(position, montagne);
	} 
	
	private Aventurier typeAventurier(String line) {
		String[] splitLine = line.split("-");

        String name = splitLine[1];
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        
        Position position = new Position(x, y);

        Orientation orientation = null;
        String o = splitLine[4];
        
        switch (o) {
		case "E":
			orientation = Orientation.EST;
			break;
		case "N":
			orientation = Orientation.NORD;
			break;
		case "S":
			orientation = Orientation.SUD;
			break;
		case "O":
			orientation = Orientation.OUEST;
			break;
		default:
			break;
        }
        List<String> stringAction = new ArrayList(Arrays.asList(splitLine[3].split("")));
        List<Action> actions = mappingActionsToList(stringAction);
        return new Aventurier(name, position, orientation, actions);
        
	}
	
	private List<Action> mappingActionsToList(List<String> stringAction){
		return stringAction.stream()
				.map(Utils::stringToAction).collect(Collectors.toList());
	}
	
	public void enregistrerResultats(Partie partie) {
        try {
			File file = new File("./resultat");
            System.out.println("Ecriture du resultat dans le fichier "+file.getName());
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            // Todo implémenter la fonction toString dans une partie
            bw.write(partie.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

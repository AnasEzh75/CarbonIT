package launch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CAT {

	public static void main(String[] args) {
		
		List<String> lines = new ArrayList<>();
		
		try (Stream<String> str = Files.lines(Paths.get(args[0]))) {

			lines = str.filter(line -> !line.startsWith("#")).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("A" + lines.toString() + "B");
		 
	}

}

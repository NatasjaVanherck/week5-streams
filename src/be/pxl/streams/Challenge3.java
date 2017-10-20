package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Challenge3 {
	public static void main(String[] args) {
		List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
		// 1. Druk alle namen van de lijst af in gesorteerde volgorde.
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		
		
		// 2. Druk alle namen af die beginnen met A (of a)
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		// Verwachte output: Amelia Ava
		
		
		// 3. Hoeveel namen beginnen er met A
		// Verwachte output: 2
		
		topNames.stream().sorted()
						   .map(s -> s = s.substring(0, 1).toUpperCase() + s.substring(1,s.length()))
						   .forEach(System.out::println);
		
		System.out.println("*********");
		
		topNames.stream().map(s -> s = s.substring(0, 1).toUpperCase() + s.substring(1,s.length()))
		                 .filter(s -> s.contains("A"))
		                 .forEach(System.out::println);
		
		System.out.println("*********");
		
		long hoeveel = topNames.stream().filter(s -> s.substring(0,1).contains("A"))
        				                .count();
		System.out.println(hoeveel);
	}
}

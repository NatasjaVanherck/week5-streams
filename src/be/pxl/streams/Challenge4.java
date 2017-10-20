package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import be.pxl.streams.Person.Gender;

public class Challenge4 {
	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(
				new Person("Sofie", 23, Gender.FEMALE),
				new Person("Adam", 31, Gender.MALE),
				new Person("Bastiaan", 25, Gender.MALE),
				new Person("Berend", 22, Gender.MALE),
				new Person("Aagje", 27, Gender.FEMALE));
		
		// 1. Geef de gemiddelde leeftijd van alle personen
		// Verwachte output: Gemiddelde leeftijd: 25.6

		OptionalDouble gemiddelde = personen.stream().mapToInt(s -> s.getAge())
				                                     .average();
		if (gemiddelde.isPresent()) {
			System.out.println("Gemiddelde leeftijd: " + gemiddelde.getAsDouble());
		} else {
			System.out.println("No result");
		}
		
		// 2. Hoeveel mannen staan er in de lijst
		// Verwachte output: Aantal mannen: 3

		long hoeveelMannen = personen.stream().map(s -> s.getGender()).filter(t -> (t == Gender.MALE)).count();
		System.out.println("Aantal mannen: " + hoeveelMannen);
		
		// 3. Hoeveel mannen ouder dan 24 staan er in de lijst
		// Verwachte output: Aantal mannen boven 24: 3

		long hoeveelMannenOuder = personen.stream().filter(t -> (t.getAge() > 24))
													.map(s -> s.getGender())
				                                   .count();
		System.out.println("Aantal mannen boven 24: " + hoeveelMannenOuder);
		
		// 4. Geef de gemiddelde leeftijd van alle mannen
		// Gemiddelde leeftijd mannen: 26.0


		OptionalDouble gemiddeldeMan = personen.stream().filter(t -> (t.getGender() == Gender.MALE))
				                              .mapToInt(s -> s.getAge())
                                              .average();
		System.out.println("Gemiddelde leeftijd mannen: " + gemiddeldeMan.getAsDouble());
		
		// 5. Maak een nieuwe persoon met als naam de eerste letter van iedere
		// persoon in de lijst
		// en als leeftijd de som van alle leeftijden
		// Maak gebruik van de methode .reduce()

		String name = personen.stream().map(s -> s.getName())
				                        .reduce("", (acc, el) -> acc + el.substring(0,1));
		int leeftijd = personen.stream().mapToInt(s -> s.getAge())
										.sum();
		Person newPerson = new Person(name, leeftijd, Gender.FEMALE);
	}
}
